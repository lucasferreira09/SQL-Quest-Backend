package com.example.SqlQuest.dtos;


public class PreviewSqlResponse {

    private String mensagem;
    private ResultadoSql resultado;

    public PreviewSqlResponse(String mensagem, ResultadoSql resultado) {
        this.mensagem = mensagem;
        this.resultado = resultado;
    }

    public ResultadoSql getResultado() {
        return resultado;
    }

    public String getMensagem() {
        return mensagem;
    }
}
