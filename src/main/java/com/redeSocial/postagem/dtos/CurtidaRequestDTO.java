package com.redeSocial.postagem.dtos;

public class CurtidaRequestDTO {
    private Integer idUsuario;
    private Integer idPostagem;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }
}
