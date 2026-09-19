package com.example.SqlQuest.dtos;

public class DesafioResponse {

    private int id;
    private int capituloId;
    private int ordem;
    private String titulo;
    private String descricao;
    private String objetivo;
    private int dificuldade;
    private String conceitoSql;
    private int xp;
    private int ouro;

    public DesafioResponse(
            int id,
            int capituloId,
            int ordem,
            String titulo,
            String descricao,
            String objetivo,
            int dificuldade,
            String conceitoSql,
            int xp,
            int ouro
    ) {
        this.id = id;
        this.capituloId = capituloId;
        this.ordem = ordem;
        this.titulo = titulo;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.dificuldade = dificuldade;
        this.conceitoSql = conceitoSql;
        this.xp = xp;
        this.ouro = ouro;
    }

    public int getId() {
        return id;
    }

    public int getCapituloId() {
        return capituloId;
    }

    public int getOrdem() {
        return ordem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public String getConceitoSql() {
        return conceitoSql;
    }

    public int getXp() {
        return xp;
    }

    public int getOuro() {
        return ouro;
    }
}