package com.example.SqlQuest.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DesafioRepository {

    private final JdbcTemplate jdbcTemplate;

    public DesafioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> buscarDesafio(int id) {

        String sql = """
                SELECT
                    id,
                    capitulo_id,
                    ordem,
                    titulo,
                    descricao,
                    objetivo,
                    dificuldade,
                    conceito_sql,
                    xp,
                    ouro,
                    ordem_importa
                FROM jogo.desafios
                WHERE id = ?
                """;

        return jdbcTemplate.queryForMap(sql, id);
    }

    public String buscarGabarito(int id) {

        String sql = """
                SELECT consulta_gabarito
                FROM jogo.desafios
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                String.class,
                id
        );
    }

    public List<Map<String, Object>> listarPorCapitulo(int capituloId) {

        String sql = """
                SELECT
                    id,
                    capitulo_id,
                    ordem,
                    titulo,
                    descricao,
                    objetivo,
                    dificuldade,
                    conceito_sql,
                    xp,
                    ouro
                FROM jogo.desafios
                WHERE capitulo_id = ?
                ORDER BY ordem
                """;

        return jdbcTemplate.queryForList(sql, capituloId);
    }

    public List<Map<String, Object>> listarBlocos(int desafioId) {

        String sql = """
            SELECT
                id,
                desafio_id,
                ordem,
                texto
            FROM jogo.blocos_desafio
            WHERE desafio_id = ?
            ORDER BY ordem
            """;

        return jdbcTemplate.queryForList(sql, desafioId);
    }
}