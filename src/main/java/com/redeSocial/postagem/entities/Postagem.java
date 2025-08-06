package com.redeSocial.postagem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String conteudo;
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Curtida> curtidas = new ArrayList<>();
    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comentario> comentarios = new ArrayList<>();

    public Postagem() {

    }

    public Postagem(Integer id, String conteudo, LocalDateTime dataCriacao, Usuario usuario, List<Curtida> curtidas, List<Comentario> comentarios) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.curtidas = curtidas;
        this.comentarios = comentarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
