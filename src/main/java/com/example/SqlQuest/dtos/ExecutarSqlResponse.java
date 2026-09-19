package com.example.SqlQuest.dtos;

public class ExecutarSqlResponse {

    private boolean sucesso;
    private boolean desafioConcluido;
    private String mensagem;
    private int xpGanho;
    private int ouroGanho;
    private ResultadoSql resultado;

    public ExecutarSqlResponse(
            boolean sucesso,
            boolean desafioConcluido,
            String mensagem,
            int xpGanho,
            int ouroGanho,
            ResultadoSql resultado
    ) {
        this.sucesso = sucesso;
        this.desafioConcluido = desafioConcluido;
        this.mensagem = mensagem;
        this.xpGanho = xpGanho;
        this.ouroGanho = ouroGanho;
        this.resultado = resultado;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public boolean isDesafioConcluido() {
        return desafioConcluido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getXpGanho() {
        return xpGanho;
    }

    public int getOuroGanho() {
        return ouroGanho;
    }

    public ResultadoSql getResultado() {
        return resultado;
    }
}