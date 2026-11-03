
package com.example.SqlQuest.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DicaRepository {

    private final JdbcTemplate jdbcTemplate;

    public DicaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // =====================================================
    // BUSCAR DICAS DE UM DESAFIO
    // =====================================================

    public List<Map<String, Object>> buscarDicas(
            int jogadorId,
            int desafioId) {

        String sql = """
        SELECT
            d.ID,
            d.DESAFIO_ID,
            d.NIVEL,

            CASE
                WHEN dc.DICA_ID IS NOT NULL THEN d.TEXTO
                ELSE NULL
            END AS TEXTO,

            d.CUSTO_OURO,

            CASE
                WHEN dc.DICA_ID IS NOT NULL THEN TRUE
                ELSE FALSE
            END AS COMPRADA

        FROM JOGO.DICAS d

        LEFT JOIN JOGO.DICAS_COMPRADAS dc
            ON dc.DICA_ID = d.ID
            AND dc.JOGADOR_ID = ?

        WHERE d.DESAFIO_ID = ?

        ORDER BY d.NIVEL
        """;

        return jdbcTemplate.queryForList(
                sql,
                jogadorId,
                desafioId
        );
    }
    // =====================================================
    // CONSULTAR OURO DO JOGADOR
    // =====================================================

    public int buscarOuro(int jogadorId) {

        String sql = """
            SELECT OURO
            FROM JOGO.JOGADORES
            WHERE ID = ?
            """;

        Integer ouro = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                jogadorId
        );

        return ouro != null ? ouro : 0;
    }

    // =====================================================
    // BUSCAR UMA DICA ESPECÍFICA
    // =====================================================

    public Map<String, Object> buscarDica(int dicaId) {

        String sql = """
            SELECT
                ID,
                DESAFIO_ID,
                NIVEL,
                TEXTO,
                CUSTO_OURO
            FROM JOGO.DICAS
            WHERE ID = ?
            """;

        return jdbcTemplate.queryForMap(sql, dicaId);
    }

    // =====================================================
    // VERIFICAR SE A DICA JÁ FOI COMPRADA
    // =====================================================

    public boolean dicaComprada(
            int jogadorId,
            int dicaId) {

        String sql = """
            SELECT COUNT(*)
            FROM JOGO.DICAS_COMPRADAS
            WHERE JOGADOR_ID = ?
              AND DICA_ID = ?
            """;

        Integer quantidade = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                jogadorId,
                dicaId
        );

        return quantidade != null && quantidade > 0;
    }

    // =====================================================
    // DESCONTAR OURO DO JOGADOR
    // =====================================================

    public boolean descontarOuro(
            int jogadorId,
            int custoOuro) {

        String sql = """
            UPDATE JOGO.JOGADORES
            SET OURO = OURO - ?
            WHERE ID = ?
              AND OURO >= ?
            """;

        int linhas = jdbcTemplate.update(
                sql,
                custoOuro,
                jogadorId,
                custoOuro
        );

        return linhas > 0;
    }

    // =====================================================
    // REGISTRAR COMPRA DA DICA
    // =====================================================

    public void registrarCompra(
            int jogadorId,
            int dicaId,
            int desafioId) {

        String sql = """
            INSERT INTO JOGO.DICAS_COMPRADAS
                (JOGADOR_ID, DICA_ID, DESAFIO_ID)
            VALUES (?, ?, ?)
            """;

        jdbcTemplate.update(
                sql,
                jogadorId,
                dicaId,
                desafioId
        );
    }
}
