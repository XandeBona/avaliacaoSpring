package com.redeSocial.postagem.dtos;

import com.redeSocial.postagem.entities.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataCadastro = usuario.getDataCadastro();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
}
