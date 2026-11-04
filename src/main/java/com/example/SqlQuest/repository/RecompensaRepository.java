
package com.example.SqlQuest.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RecompensaRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecompensaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Busca os itens recebidos pelo desafio
    public List<Map<String, Object>> buscarItens(int desafioId) {

        String sql = """
            SELECT
                i.ID AS ITEM_ID,
                i.NOME AS NOME,
                i.DESCRICAO AS DESCRICAO,
                i.IMAGE_URL AS IMAGEM,
                rd.QUANTIDADE AS QUANTIDADE
            FROM JOGO.RECOMPENSAS_DESAFIO rd
            INNER JOIN JOGO.ITENS i
                ON i.ID = rd.ITEM_ID
            WHERE rd.DESAFIO_ID = ?
              AND rd.ITEM_ID IS NOT NULL
              AND rd.QUANTIDADE > 0
            """;

        return jdbcTemplate.queryForList(sql, desafioId);
    }

    // Busca as conquistas recebidas pelo desafio
    public List<Map<String, Object>> buscarConquistas(int desafioId) {

        String sql = """
            SELECT
                c.ID AS CONQUISTA_ID,
                c.NOME AS NOME,
                c.DESCRICAO AS DESCRICAO,
                c.IMAGE_URL AS IMAGEM
            FROM JOGO.RECOMPENSAS_DESAFIO rd
            INNER JOIN JOGO.CONQUISTAS c
                ON c.ID = rd.CONQUISTA_ID
            WHERE rd.DESAFIO_ID = ?
              AND rd.CONQUISTA_ID IS NOT NULL
            """;

        return jdbcTemplate.queryForList(sql, desafioId);
    }

    // Adiciona ou soma a quantidade de um item no inventário
    public void adicionarItem(
            int jogadorId,
            int itemId,
            int quantidade) {

        String atualizar = """
            UPDATE JOGO.INVENTARIO_JOGADOR
            SET QUANTIDADE = QUANTIDADE + ?
            WHERE JOGADOR_ID = ?
              AND ITEM_ID = ?
            """;

        int linhasAtualizadas = jdbcTemplate.update(
                atualizar,
                quantidade,
                jogadorId,
                itemId
        );

        if (linhasAtualizadas == 0) {

            String inserir = """
                INSERT INTO JOGO.INVENTARIO_JOGADOR
                    (JOGADOR_ID, ITEM_ID, QUANTIDADE)
                VALUES (?, ?, ?)
                """;

            jdbcTemplate.update(
                    inserir,
                    jogadorId,
                    itemId,
                    quantidade
            );
        }
    }

    // Registra uma conquista somente se ainda não existir
    public void desbloquearConquista(
            int jogadorId,
            int conquistaId) {

        String sql = """
            MERGE INTO JOGO.CONQUISTAS_JOGADOR
                (JOGADOR_ID, CONQUISTA_ID, DESBLOQUEADA_EM)
            KEY (JOGADOR_ID, CONQUISTA_ID)
            VALUES (?, ?, CURRENT_TIMESTAMP)
            """;

        // Verificamos antes para não sobrescrever a data
        // de desbloqueio de uma conquista já existente.
        String verificar = """
            SELECT COUNT(*)
            FROM JOGO.CONQUISTAS_JOGADOR
            WHERE JOGADOR_ID = ?
              AND CONQUISTA_ID = ?
            """;

        Integer quantidade = jdbcTemplate.queryForObject(
                verificar,
                Integer.class,
                jogadorId,
                conquistaId
        );

        if (quantidade == null || quantidade == 0) {
            jdbcTemplate.update(sql, jogadorId, conquistaId);
        }
    }

    // Atualiza XP e ouro do jogador
    public void adicionarXpEOuro(
            int jogadorId,
            int xp,
            int ouro) {

        String sql = """
            UPDATE JOGO.JOGADORES
            SET XP = XP + ?,
                OURO = OURO + ?
            WHERE ID = ?
            """;

        int linhas = jdbcTemplate.update(
                sql,
                xp,
                ouro,
                jogadorId
        );

        if (linhas == 0) {
            throw new IllegalStateException("Jogador não encontrado.");
        }
        //jdbcTemplate.update(sql, xp, ouro, jogadorId);
    }
}
