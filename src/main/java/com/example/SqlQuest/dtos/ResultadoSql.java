package com.example.SqlQuest.dtos;

import java.util.List;

public class ResultadoSql {

    private List<String> colunas;
    private List<List<Object>> linhas;

    public ResultadoSql(List<String> colunas, List<List<Object>> linhas) {

        this.colunas = colunas;
        this.linhas = linhas;
    }

    public List<String> getColunas() {
        return colunas;
    }

    public List<List<Object>> getLinhas() {
        return linhas;
    }
}