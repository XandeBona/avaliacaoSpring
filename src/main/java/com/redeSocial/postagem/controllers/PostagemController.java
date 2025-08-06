package com.redeSocial.postagem.controllers;

import com.redeSocial.postagem.dtos.PostagemRequestDTO;
import com.redeSocial.postagem.dtos.PostagemResponseDTO;
import com.redeSocial.postagem.entities.Postagem;
import com.redeSocial.postagem.entities.Usuario;
import com.redeSocial.postagem.repositories.PostagemRepository;
import com.redeSocial.postagem.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postagens")
public class PostagemController {
    private final PostagemRepository postagemRepository;
    private final UsuarioRepository usuarioRepository;


    public PostagemController(PostagemRepository postagemRepository, UsuarioRepository usuarioRepository) {
        this.postagemRepository = postagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //Adicionar postagem à um usuario
    @PostMapping
    public PostagemResponseDTO adicionarPostagem(@RequestBody PostagemRequestDTO request) {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow();

        Postagem novaPostagem = new Postagem();
        novaPostagem.setConteudo(request.getConteudo());
        novaPostagem.setDataCriacao(request.getDataCriacao());
        novaPostagem.setUsuario(usuario);

        postagemRepository.save(novaPostagem);

        return new PostagemResponseDTO(novaPostagem);
    }

}
