package com.redeSocial.postagem.entities;

import jakarta.persistence.*;

@Entity
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

    public Curtida () {

    }

    public Curtida(Integer id, Usuario usuario, Postagem postagem) {
        this.id = id;
        this.usuario = usuario;
        this.postagem = postagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}
