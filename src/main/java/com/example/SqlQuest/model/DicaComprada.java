package com.example.SqlQuest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "DICAS_COMPRADAS",
        schema = "JOGO",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_JOGADOR_DICA",
                        columnNames = {"JOGADOR_ID", "DICA_ID"}
                )
        }
)
public class DicaComprada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JOGADOR_ID", nullable = false)
    private Long jogadorId;

    @Column(name = "DICA_ID", nullable = false)
    private Long dicaId;

    @Column(name = "DATA_COMPRA")
    private LocalDateTime dataCompra;

    @PrePersist
    public void prePersist() {
        dataCompra = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Long jogadorId) {
        this.jogadorId = jogadorId;
    }

    public Long getDicaId() {
        return dicaId;
    }

    public void setDicaId(Long dicaId) {
        this.dicaId = dicaId;
    }
}