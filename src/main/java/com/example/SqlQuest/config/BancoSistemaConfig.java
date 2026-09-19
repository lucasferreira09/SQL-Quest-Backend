package com.example.SqlQuest.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class BancoSistemaConfig {

    @Bean
    @Primary
    public DataSource dataSourceSistema(
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplateSistema(
            DataSource dataSourceSistema) {

        return new JdbcTemplate(dataSourceSistema);
    }
}