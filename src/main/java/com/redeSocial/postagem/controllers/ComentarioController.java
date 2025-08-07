package com.redeSocial.postagem.controllers;

import com.redeSocial.postagem.dtos.ComentarioRequestDTO;
import com.redeSocial.postagem.dtos.ComentarioResponseDTO;
import com.redeSocial.postagem.entities.Comentario;
import com.redeSocial.postagem.entities.Postagem;
import com.redeSocial.postagem.entities.Usuario;
import com.redeSocial.postagem.repositories.ComentarioRepository;
import com.redeSocial.postagem.repositories.PostagemRepository;
import com.redeSocial.postagem.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;

    public ComentarioController(ComentarioRepository comentarioRepository, UsuarioRepository usuarioRepository, PostagemRepository postagemRepository) {
        this.comentarioRepository = comentarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    //Adicionar comentario à uma postagem
    @PostMapping
    public ComentarioResponseDTO adicionarComentario(@RequestBody ComentarioRequestDTO request) {
        Postagem postagem = postagemRepository.findById(request.getIdPostagem()).orElseThrow();
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow();

        Comentario novoComentario = new Comentario();
        novoComentario.setTexto(request.getTexto());
        novoComentario.setDataCriacao(request.getDataCriacao());
        novoComentario.setPostagem(postagem);
        novoComentario.setUsuario(usuario);

        comentarioRepository.save(novoComentario);

        return new ComentarioResponseDTO(novoComentario);
    }

//    //Listar comentario por postagem
//    @GetMapping("/postagens/{id}/comentarios")
//    public List<Comentario> buscarComentarioDePostagem(@PathVariable Integer idPostagem) {
//        Comentario comentario = comentarioRepository.findById(idPostagem);
//        return comentario;
//    }
}
