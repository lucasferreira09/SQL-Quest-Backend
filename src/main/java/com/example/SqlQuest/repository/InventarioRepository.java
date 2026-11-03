package com.example.SqlQuest.repository;

import com.example.SqlQuest.dtos.ConquistaInventarioDTO;
import com.example.SqlQuest.dtos.DicasCompradasDTO;
import com.example.SqlQuest.dtos.ItemInventarioDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public InventarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<ItemInventarioDTO> listarPorJogador(Long jogadorId) {

        String sql = """
        SELECT
            i.id,
            i.nome,
            i.descricao,
            i.tipo,
            ij.quantidade,
            i.imagem_url
        FROM jogo.inventario_jogador ij
        INNER JOIN jogo.itens i
            ON i.id = ij.item_id
        WHERE ij.jogador_id = ?
        ORDER BY i.nome
        """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new ItemInventarioDTO(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getString("imagem_url")
                ),
                jogadorId
        );
    }



    public List<ConquistaInventarioDTO> listarConquistasPorJogador(Long jogadorId) {

        String sql = """
        SELECT
            c.ID AS ID,
            c.NOME AS NOME,
            c.DESCRICAO AS DESCRICAO,
            c.IMAGE_URL AS IMAGEM_URL,
            cj.DESBLOQUEADA_EM AS DESBLOQUEADA_EM
        FROM JOGO.CONQUISTAS_JOGADOR cj
        INNER JOIN JOGO.CONQUISTAS c
            ON c.ID = cj.CONQUISTA_ID
        WHERE cj.JOGADOR_ID = ?
        ORDER BY cj.DESBLOQUEADA_EM DESC
        """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new ConquistaInventarioDTO(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("DESCRICAO"),
                        rs.getString("IMAGEM_URL"),
                        rs.getTimestamp("DESBLOQUEADA_EM") != null
                                ? rs.getTimestamp("DESBLOQUEADA_EM").toLocalDateTime()
                                : null
                ),
                jogadorId
        );
    }

    public List<DicasCompradasDTO> listarDicasCompradasPorJogador(Long jogadorId) {

        String sql = """
        SELECT
                                        dc.DICA_ID AS DICA_ID,
                                        dc.DESAFIO_ID AS DESAFIO_ID,
                                        d.NIVEL AS NIVEL,
                                        d.TEXTO AS TEXTO,
                                        d.CUSTO_OURO AS CUSTO_OURO,
                                        dc.COMPRADO_EM AS COMPRADO_EM
                                    FROM JOGO.DICAS_COMPRADAS dc
                                    INNER JOIN JOGO.DICAS d
                                        ON d.ID = dc.DICA_ID
                                    WHERE dc.JOGADOR_ID = ?
                                    ORDER BY dc.COMPRADO_EM DESC
    """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new DicasCompradasDTO(
                        rs.getInt("DICA_ID"),
                        rs.getInt("DESAFIO_ID"),
                        rs.getString("NIVEL"),
                        rs.getString("TEXTO"),
                        rs.getInt("CUSTO_OURO"),
                        rs.getTimestamp("COMPRADO_EM") != null
                                ? rs.getTimestamp("COMPRADO_EM").toLocalDateTime()
                                : null
                ),
                jogadorId
        );
    }

}
