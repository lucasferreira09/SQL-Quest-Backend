
package com.example.SqlQuest.dtos;

public class ExecutarSqlRequest {

    private String sql;
    private Integer jogadorId;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Integer jogadorId) {
        this.jogadorId = jogadorId;
    }
}
