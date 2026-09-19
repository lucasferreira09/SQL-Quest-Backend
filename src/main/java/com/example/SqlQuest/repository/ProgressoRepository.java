package com.example.SqlQuest.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgressoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProgressoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> buscarDesafiosConcluidos(int jogadorId) {

        String sql = """
                SELECT desafio_id
                FROM jogo.progresso_desafios
                WHERE jogador_id = ?
                  AND concluido = TRUE
                ORDER BY desafio_id
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getInt("desafio_id"),
                jogadorId
        );
    }

    public void concluirDesafio(int jogadorId, int desafioId) {

        String sql = """
                MERGE INTO jogo.progresso_desafios
                (jogador_id, desafio_id, concluido, concluido_em)
                KEY (jogador_id, desafio_id)
                VALUES (?, ?, TRUE, CURRENT_TIMESTAMP)
                """;

        jdbcTemplate.update(sql, jogadorId, desafioId);
    }

    public boolean desafioConcluido(int jogadorId, int desafioId) {

        String sql = """
            SELECT COUNT(*)
            FROM jogo.progresso_desafios
            WHERE jogador_id = ?
              AND desafio_id = ?
              AND concluido = TRUE
            """;

        Integer quantidade = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                jogadorId,
                desafioId
        );

        return quantidade != null && quantidade > 0;
    }
}