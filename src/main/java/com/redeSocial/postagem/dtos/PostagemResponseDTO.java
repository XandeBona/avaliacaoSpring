package com.redeSocial.postagem.dtos;

import com.redeSocial.postagem.entities.Postagem;

import java.time.LocalDateTime;

public class PostagemResponseDTO {
    private Integer id;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private UsuarioResponseDTO usuario;

    public PostagemResponseDTO(Postagem postagem) {
        this.id = postagem.getId();
        this.conteudo = postagem.getConteudo();
        this.dataCriacao = postagem.getDataCriacao();
        this.usuario = new UsuarioResponseDTO(postagem.getUsuario());
    }

    public Integer getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }
}
