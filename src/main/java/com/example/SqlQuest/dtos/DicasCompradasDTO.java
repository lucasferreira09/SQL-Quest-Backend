package com.example.SqlQuest.dtos;

import java.time.LocalDateTime;

public class DicasCompradasDTO {
    private int dicaId;
    private int desafioId;
    private String nivel;
    private String texto;
    private int custoOuro;
    private LocalDateTime compradoEm;

    public DicasCompradasDTO(int dicaId, int desafioId, String nivel, String texto, int custoOuro, LocalDateTime compradoEm) {
        this.dicaId = dicaId;
        this.desafioId = desafioId;
        this.nivel = nivel;
        this.texto = texto;
        this.custoOuro = custoOuro;
        this.compradoEm = compradoEm;
    }

    public int getDicaId() {
        return dicaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCustoOuro() {
        return custoOuro;
    }

    public void setCustoOuro(int custoOuro) {
        this.custoOuro = custoOuro;
    }

    public LocalDateTime getCompradoEm() {
        return compradoEm;
    }

    public void setCompradoEm(LocalDateTime compradoEm) {
        this.compradoEm = compradoEm;
    }

    public int getDesafioId() {
        return desafioId;
    }

    public void setDesafioId(int desafioId) {
        this.desafioId = desafioId;
    }
}
