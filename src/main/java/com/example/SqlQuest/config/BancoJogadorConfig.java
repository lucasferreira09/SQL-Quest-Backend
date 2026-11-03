
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

    @Value("${sqlquest.jogador.url}")
    private String bancoUrl;

    @Value("${sqlquest.jogador.username}")
    private String bancoUsername;

    @Value("${sqlquest.jogador.password}")
    private String bancoPassword;

    @Value("${sqlquest.jogador.driver}")
    private String bancoDriver;

    @Bean
    public DataSource dataSourceJogador() {
        return DataSourceBuilder.create()
                .url(bancoUrl)
                .username(bancoUsername)
                .password(bancoPassword)
                .driverClassName(bancoDriver)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplateJogador(
            @Qualifier("dataSourceJogador")
            DataSource dataSourceJogador) {

        return new JdbcTemplate(dataSourceJogador);
    }
}
