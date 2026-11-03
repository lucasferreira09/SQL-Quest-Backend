
package com.example.SqlQuest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BancoSistemaConfig {

    @Value("${spring.datasource.url}")
    private String bancoUrl;

    @Value("${spring.datasource.username}")
    private String bancoUsername;

    @Value("${spring.datasource.password}")
    private String bancoPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String bancoDriver;

    @Bean
    @Primary
    public DataSource dataSourceSistema() {

        return DataSourceBuilder.create()
                .url(bancoUrl)
                .username(bancoUsername)
                .password(bancoPassword)
                .driverClassName(bancoDriver)
                .build();
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplateSistema(
            @Qualifier("dataSourceSistema")
            DataSource dataSourceSistema) {

        return new JdbcTemplate(dataSourceSistema);
    }
}
