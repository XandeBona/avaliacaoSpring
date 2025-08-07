package com.redeSocial.postagem.dtos;

import com.redeSocial.postagem.entities.Curtida;

public class CurtidaResponseDTO {
    private UsuarioResponseDTO usuario;
    private PostagemResponseDTO postagem;

    public CurtidaResponseDTO(Curtida curtida) {
        this.usuario = new UsuarioResponseDTO(curtida.getUsuario());
        this.postagem = new PostagemResponseDTO(curtida.getPostagem());
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public PostagemResponseDTO getPostagem() {
        return postagem;
    }
}
