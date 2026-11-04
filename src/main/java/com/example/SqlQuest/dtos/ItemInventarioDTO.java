
package com.example.SqlQuest.dtos;

public class ItemInventarioDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private Integer quantidade;
    private String imageUrl;

    public ItemInventarioDTO(
            Long id,
            String nome,
            String descricao,
            String tipo,
            Integer quantidade,
            String imageUrl) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.imageUrl = imageUrl;
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

    public String getTipo() {
        return tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
