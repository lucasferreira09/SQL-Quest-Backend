package com.example.SqlQuest.dtos;

public class CapituloResponse {

    private int id;
    private int numero;
    private String nome;
    private String descricao;
    private String conceitoPrincipal;
    private String recompensa;

    public CapituloResponse(
            int id,
            int numero,
            String nome,
            String descricao,
            String conceitoPrincipal,
            String recompensa
    ) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.conceitoPrincipal = conceitoPrincipal;
        this.recompensa = recompensa;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getConceitoPrincipal() {
        return conceitoPrincipal;
    }

    public String getRecompensa() {
        return recompensa;
    }
}