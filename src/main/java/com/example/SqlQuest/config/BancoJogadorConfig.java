package com.example.SqlQuest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BancoJogadorConfig {

    @Value("${banco-url}")
    String bancoUrl;

    @Bean
    public DataSource dataSourceJogador() {
        return DataSourceBuilder.create()
                .url(bancoUrl)
                .username("jogador")
                .password("sqlquest")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplateJogador(
            @Qualifier("dataSourceJogador")
            DataSource dataSourceJogador) {

        return new JdbcTemplate(dataSourceJogador);
    }
}