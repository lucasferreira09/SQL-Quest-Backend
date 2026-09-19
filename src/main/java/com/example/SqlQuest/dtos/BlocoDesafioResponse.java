package com.example.SqlQuest.dtos;

public class BlocoDesafioResponse {

    private int id;
    private int desafioId;
    private int ordem;
    private String texto;

    public BlocoDesafioResponse(
            int id,
            int desafioId,
            int ordem,
            String texto
    ) {
        this.id = id;
        this.desafioId = desafioId;
        this.ordem = ordem;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public int getDesafioId() {
        return desafioId;
    }

    public int getOrdem() {
        return ordem;
    }

    public String getTexto() {
        return texto;
    }
}