package com.example.SqlQuest.service;

import com.example.SqlQuest.dtos.CapituloResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitulosService {

    private final JdbcTemplate jdbcTemplate;

    public CapitulosService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CapituloResponse> listarCapitulos() {

        String sql = """
                SELECT
                    id,
                    numero,
                    nome,
                    descricao,
                    conceito_principal,
                    recompensa
                FROM jogo.capitulos
                ORDER BY numero
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new CapituloResponse(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("conceito_principal"),
                        rs.getString("recompensa")
                )
        );
    }
}