package com.example.SqlQuest.service;

import com.example.SqlQuest.dtos.BlocoDesafioResponse;
import com.example.SqlQuest.dtos.DesafioResponse;
import com.example.SqlQuest.dtos.ResultadoSql;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.SqlQuest.dtos.ExecutarSqlResponse;
import com.example.SqlQuest.repository.DesafioRepository;
import org.springframework.stereotype.Service;
import com.example.SqlQuest.repository.RecompensaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class DesafioService {

    private final JdbcTemplate jdbcTemplate;
    @Qualifier("jdbcTemplateJogador")
    private final JdbcTemplate jdbcTemplateJogador;
    private final DesafioRepository desafioRepository;
    private final RecompensaRepository recompensaRepository;
    private final ResultadoSqlComparator resultadoSqlComparator;
    private final ProgressoService progressoService;
    private static final Set<String> TABELAS_PERMITIDAS = Set.of(
            "reino.vilas",
            "reino.habitantes",
            "reino.soldados",
            "reino.armas",
            "reino.recursos",
            "reino.entregas",
            "reino.criaturas",
            "reino.mensagens",
            "reino.registros_corrompidos"
    );

    public DesafioService(
            DesafioRepository desafioRepository,
            ResultadoSqlComparator resultadoSqlComparator,
            ProgressoService progressoService,
            JdbcTemplate jdbcTemplate,
            @Qualifier("jdbcTemplateJogador")
            JdbcTemplate jdbcTemplateJogador, RecompensaRepository recompensaRepository
    ) {
        this.desafioRepository = desafioRepository;
        this.resultadoSqlComparator = resultadoSqlComparator;
        this.progressoService = progressoService;
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcTemplateJogador = jdbcTemplateJogador;
        this.recompensaRepository = recompensaRepository;
    }


    @Transactional
    public ExecutarSqlResponse executar(int desafioId, Integer jogadorId, String sql) {

        Map<String, Object> desafio;

        try {
            desafio = desafioRepository.buscarDesafio(desafioId);
        } catch (Exception e) {
            return respostaErro("Desafio não encontrado.");
        }

        if (sql == null || sql.isBlank()) {
            return respostaErro("Digite uma consulta SQL.");
        }

        String erroValidacao = validarSql(sql);

        if (erroValidacao != null) {
            return respostaErro(erroValidacao);
        }

        try {
            validarTabelas(sql);
        } catch (IllegalArgumentException e) {
            return respostaErro(e.getMessage());
        }

        ResultadoSql resultadoJogador;

        try {
            resultadoJogador = executarSqlJogador(sql);
        } catch (Exception e) {
            return new ExecutarSqlResponse(
                    false,
                    false,
                    "A consulta demorou demais ou não pôde ser executada.",
                    0,
                    0,
                    new ResultadoSql(
                            Collections.emptyList(),
                            Collections.emptyList()
                    )
            );
        }

        String consultaGabarito;

        try {
            consultaGabarito = desafioRepository.buscarGabarito(desafioId);
        } catch (Exception e) {
            return respostaErro("Não foi possível verificar o desafio.");
        }

        ResultadoSql resultadoEsperado;

        try {
            resultadoEsperado = executarSqlInterno(consultaGabarito);
        } catch (Exception e) {
            return respostaErro("Erro interno ao verificar o desafio.");
        }

        boolean acertou = resultadoSqlComparator.comparar(
                resultadoJogador,
                resultadoEsperado,
                Boolean.TRUE.equals(desafio.get("ORDEM_IMPORTA"))
        );

        if (!acertou) {
            return new ExecutarSqlResponse(
                    true,
                    false,
                    "A consulta foi executada, mas o resultado não corresponde ao objetivo do desafio.",
                    0,
                    0,
                    resultadoJogador
            );
        }

        int xp = ((Number) desafio.get("XP")).intValue();
        int ouro = ((Number) desafio.get("OURO")).intValue();

        boolean jaConcluido = progressoService.desafioConcluido(
                jogadorId,
                desafioId
        );

        // Não entrega recompensas novamente
        if (jaConcluido) {
            return new ExecutarSqlResponse(
                    true,
                    true,
                    "Desafio já concluído anteriormente.",
                    0,
                    0,
                    resultadoJogador
            );
        }

        // Busca as recompensas antes de registrá-las
        List<Map<String, Object>> itens =
                recompensaRepository.buscarItens(desafioId);

        List<Map<String, Object>> conquistas =
                recompensaRepository.buscarConquistas(desafioId);

        // Registra a conclusão do desafio
        progressoService.concluirDesafio(jogadorId, desafioId);

        // Atualiza XP e ouro
        recompensaRepository.adicionarXpEOuro(
                jogadorId,
                xp,
                ouro
        );

        // Entrega os itens
        for (Map<String, Object> item : itens) {

            int itemId = ((Number) item.get("ITEM_ID")).intValue();

            int quantidade =
                    ((Number) item.get("QUANTIDADE")).intValue();

            recompensaRepository.adicionarItem(
                    jogadorId,
                    itemId,
                    quantidade
            );
        }

        // Desbloqueia as conquistas
        for (Map<String, Object> conquista : conquistas) {

            int conquistaId =
                    ((Number) conquista.get("CONQUISTA_ID")).intValue();

            recompensaRepository.desbloquearConquista(
                    jogadorId,
                    conquistaId
            );
        }

        return new ExecutarSqlResponse(
                true,
                true,
                "Desafio concluído! Recompensas recebidas.",
                xp,
                ouro,
                resultadoJogador,
                itens,
                conquistas
        );
    }


    private String validarSql(String sql) {

        String sqlNormalizado = sql.trim().toLowerCase();

        if (!sqlNormalizado.startsWith("select")) {
            return "Apenas consultas SELECT são permitidas.";
        }


        if (sqlNormalizado.contains("jogo.")) {
            return "Essa área do banco de dados não pode ser consultada.";
        }

        String[] comandosBloqueados = {
                "insert",
                "update",
                "delete",
                "drop",
                "alter",
                "truncate",
                "create",
                "merge",
                "grant",
                "revoke"
        };

        for (String comando : comandosBloqueados) {

            if (sqlNormalizado.matches(".*\\b" + comando + "\\b.*")) {
                return "A consulta contém um comando não permitido.";
            }
        }

        return null;
    }

    private ExecutarSqlResponse respostaErro(String mensagem) {

        return new ExecutarSqlResponse(
                false,
                false,
                mensagem,
                0,
                0,
                new ResultadoSql(Collections.emptyList(), Collections.emptyList())
        );
    }

    private void validarTabelas(String sql) {

        String consulta = sql.toLowerCase();

        for (String tabela : TABELAS_PERMITIDAS) {
            consulta = consulta.replace(tabela, "");
        }

        if (consulta.contains("reino.")) {
            throw new IllegalArgumentException("Essa tabela não está disponível neste desafio.");
        }
    }

    private ResultadoSql executarSqlJogador(String sql) {

        return jdbcTemplateJogador.query(connection -> {

                    var statement = connection.prepareStatement(sql);
                    statement.setMaxRows(100);
                    statement.setQueryTimeout(3);

                    return statement;
                },

                resultSet -> {

                    var metadata = resultSet.getMetaData();

                    int quantidadeColunas = metadata.getColumnCount();

                    List<String> colunas = new ArrayList<>();

                    for (int i = 1; i <= quantidadeColunas; i++) {
                        colunas.add(metadata.getColumnLabel(i));
                    }

                    List<List<Object>> linhas = new ArrayList<>();

                    while (resultSet.next()) {

                        List<Object> linha = new ArrayList<>();

                        for (int i = 1; i <= quantidadeColunas; i++) {
                            linha.add(resultSet.getObject(i));
                        }

                        linhas.add(linha);
                    }

                    return new ResultadoSql(colunas, linhas);
                }
        );
    }

    private ResultadoSql executarSqlInterno(String sql) {

        return jdbcTemplate.query(sql, resultSet -> {

                    var metadata = resultSet.getMetaData();

                    int quantidadeColunas = metadata.getColumnCount();

                    List<String> colunas = new ArrayList<>();

                    for (int i = 1; i <= quantidadeColunas; i++) {
                        colunas.add(metadata.getColumnLabel(i));
                    }

                    List<List<Object>> linhas = new ArrayList<>();

                    while (resultSet.next()) {

                        List<Object> linha = new ArrayList<>();

                        for (int i = 1; i <= quantidadeColunas; i++) {
                            linha.add(resultSet.getObject(i));
                        }

                        linhas.add(linha);
                    }

                    return new ResultadoSql(colunas, linhas);
                }
        );
    }

    public List<DesafioResponse> listarPorCapitulo(int capituloId) {

        return desafioRepository
                .listarPorCapitulo(capituloId)
                .stream()
                .map(desafio -> new DesafioResponse(
                        ((Number) desafio.get("id")).intValue(),
                        ((Number) desafio.get("capitulo_id")).intValue(),
                        ((Number) desafio.get("ordem")).intValue(),
                        (String) desafio.get("titulo"),
                        (String) desafio.get("descricao"),
                        (String) desafio.get("objetivo"),
                        ((Number) desafio.get("dificuldade")).intValue(),
                        (String) desafio.get("conceito_sql"),
                        ((Number) desafio.get("xp")).intValue(),
                        ((Number) desafio.get("ouro")).intValue()
                ))
                .toList();
    }

    public DesafioResponse buscarDesafio(int id) {

        Map<String, Object> desafio = desafioRepository.buscarDesafio(id);

        return new DesafioResponse(
                ((Number) desafio.get("id")).intValue(),
                ((Number) desafio.get("capitulo_id")).intValue(),
                ((Number) desafio.get("ordem")).intValue(),
                (String) desafio.get("titulo"),
                (String) desafio.get("descricao"),
                (String) desafio.get("objetivo"),
                ((Number) desafio.get("dificuldade")).intValue(),
                (String) desafio.get("conceito_sql"),
                ((Number) desafio.get("xp")).intValue(),
                ((Number) desafio.get("ouro")).intValue()
        );
    }

    public List<BlocoDesafioResponse> listarBlocos(int desafioId) {

        return desafioRepository
                .listarBlocos(desafioId)
                .stream()
                .map(bloco -> new BlocoDesafioResponse(
                        ((Number) bloco.get("id")).intValue(),
                        ((Number) bloco.get("desafio_id")).intValue(),
                        ((Number) bloco.get("ordem")).intValue(),
                        (String) bloco.get("texto")
                ))
                .toList();
    }
}