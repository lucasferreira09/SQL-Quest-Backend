
package com.example.SqlQuest.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Connection;

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

        String banco = jdbcTemplate.execute(
                (ConnectionCallback<String>) connection ->
                        connection.getMetaData().getDatabaseProductName()
        );
        // PostgreSQL
        if ("PostgreSQL".equalsIgnoreCase(banco)) {

            String sql = """
                    INSERT INTO jogo.progresso_desafios
                        (jogador_id, desafio_id, concluido, concluido_em)
                    VALUES (?, ?, TRUE, CURRENT_TIMESTAMP)
                    ON CONFLICT (jogador_id, desafio_id)
                    DO UPDATE SET
                        concluido = TRUE,
                        concluido_em = CURRENT_TIMESTAMP
                    """;

            jdbcTemplate.update(sql, jogadorId, desafioId);

        } else {

            // H2
            String sql = """
                    MERGE INTO jogo.progresso_desafios
                    (jogador_id, desafio_id, concluido, concluido_em)
                    KEY (jogador_id, desafio_id)
                    VALUES (?, ?, TRUE, CURRENT_TIMESTAMP)
                    """;

            jdbcTemplate.update(sql, jogadorId, desafioId);
        }
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
