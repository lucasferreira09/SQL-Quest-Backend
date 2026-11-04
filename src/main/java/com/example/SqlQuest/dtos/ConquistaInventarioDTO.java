
package com.example.SqlQuest.dtos;

import java.time.LocalDateTime;

public class ConquistaInventarioDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String imageUrl;
    private LocalDateTime desbloqueadaEm;

    public ConquistaInventarioDTO(
            Long id,
            String nome,
            String descricao,
            String imageUrl,
            LocalDateTime desbloqueadaEm
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imageUrl = imageUrl;
        this.desbloqueadaEm = desbloqueadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getDesbloqueadaEm() {
        return desbloqueadaEm;
    }
}
