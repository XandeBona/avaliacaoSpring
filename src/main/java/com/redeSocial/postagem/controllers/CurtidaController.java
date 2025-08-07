package com.redeSocial.postagem.controllers;

import com.redeSocial.postagem.dtos.CurtidaRequestDTO;
import com.redeSocial.postagem.dtos.CurtidaResponseDTO;
import com.redeSocial.postagem.entities.Curtida;
import com.redeSocial.postagem.entities.Postagem;
import com.redeSocial.postagem.entities.Usuario;
import com.redeSocial.postagem.repositories.CurtidaRepository;
import com.redeSocial.postagem.repositories.PostagemRepository;
import com.redeSocial.postagem.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurtidaController {
    private final CurtidaRepository curtidaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;

    public CurtidaController(CurtidaRepository curtidaRepository, UsuarioRepository usuarioRepository, PostagemRepository postagemRepository) {
        this.curtidaRepository = curtidaRepository;
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    //Adicionar uma curtida à uma postagem
    @PostMapping("/curtidas")
    public CurtidaResponseDTO adicionarCurtida(@RequestBody CurtidaRequestDTO request) {
        Postagem postagem = postagemRepository.findById(request.getIdPostagem()).orElseThrow();
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow();

        Curtida novaCurtida = new Curtida();
        novaCurtida.setPostagem(postagem);
        novaCurtida.setUsuario(usuario);

        curtidaRepository.save(novaCurtida);

        return new CurtidaResponseDTO(novaCurtida);
    }

    //Listar curtidas por postagem
    @GetMapping("/postagens/{id}/curtidas")
    public List<Curtida> buscarCurtidasDePostagem(@PathVariable Integer id) {
        return curtidaRepository.findByPostagemId(id);
    }
}
