package com.example.SqlQuest.model;


import jakarta.persistence.*;

@Entity
@Table(name = "CARTEIRA_JOGADOR", schema = "JOGO")
public class CarteiraJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JOGADOR_ID", nullable = false, unique = true)
    private Long jogadorId;

    @Column(name = "OURO", nullable = false)
    private Integer ouro = 0;

    public Long getId() {
        return id;
    }

    public Long getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Long jogadorId) {
        this.jogadorId = jogadorId;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }
}