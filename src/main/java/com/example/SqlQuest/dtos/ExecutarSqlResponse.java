
package com.example.SqlQuest.dtos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExecutarSqlResponse {

    private boolean sucesso;
    private boolean desafioConcluido;
    private String mensagem;
    private int xpGanho;
    private int ouroGanho;
    private ResultadoSql resultado;

    private List<Map<String, Object>> itensRecebidos;
    private List<Map<String, Object>> conquistasDesbloqueadas;

    public ExecutarSqlResponse(
            boolean sucesso,
            boolean desafioConcluido,
            String mensagem,
            int xpGanho,
            int ouroGanho,
            ResultadoSql resultado
    ) {
        this(
                sucesso,
                desafioConcluido,
                mensagem,
                xpGanho,
                ouroGanho,
                resultado,
                Collections.emptyList(),
                Collections.emptyList()
        );
    }

    public ExecutarSqlResponse(
            boolean sucesso,
            boolean desafioConcluido,
            String mensagem,
            int xpGanho,
            int ouroGanho,
            ResultadoSql resultado,
            List<Map<String, Object>> itensRecebidos,
            List<Map<String, Object>> conquistasDesbloqueadas
    ) {
        this.sucesso = sucesso;
        this.desafioConcluido = desafioConcluido;
        this.mensagem = mensagem;
        this.xpGanho = xpGanho;
        this.ouroGanho = ouroGanho;
        this.resultado = resultado;
        this.itensRecebidos = itensRecebidos;
        this.conquistasDesbloqueadas = conquistasDesbloqueadas;
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

    public List<Map<String, Object>> getItensRecebidos() {
        return itensRecebidos;
    }

    public List<Map<String, Object>> getConquistasDesbloqueadas() {
        return conquistasDesbloqueadas;
    }
}
