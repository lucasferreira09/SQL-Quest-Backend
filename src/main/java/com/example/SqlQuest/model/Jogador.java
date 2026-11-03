
package com.example.SqlQuest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JOGADORES", schema = "JOGO")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "XP", nullable = false)
    private Integer xp = 0;

    @Column(name = "OURO", nullable = false)
    private Integer ouro = 0;

    @Column(name = "NIVEL", nullable = false)
    private Integer nivel = 1;

    @Column(name = "CRIADO_EM", nullable = false)
    private LocalDateTime criadoEm;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getOuro() {
        return ouro;
    }

    public Integer getNivel() {
        return nivel;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @PrePersist
    public void prePersist() {
        if (criadoEm == null) {
            criadoEm = LocalDateTime.now();
        }
    }

}
