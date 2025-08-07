package com.redeSocial.postagem.dtos;

import com.redeSocial.postagem.entities.Comentario;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {
    private Integer id;
    private String texto;
    private UsuarioResponseDTO usuario;
    private PostagemResponseDTO postagem;
    private LocalDateTime dataCriacao;

    public ComentarioResponseDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.texto = comentario.getTexto();
        this.usuario = new UsuarioResponseDTO(comentario.getUsuario());
        this.postagem = new PostagemResponseDTO(comentario.getPostagem());
        this.dataCriacao = comentario.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public PostagemResponseDTO getPostagem() {
        return postagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
