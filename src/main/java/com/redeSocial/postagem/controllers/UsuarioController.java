package com.redeSocial.postagem.controllers;

import com.redeSocial.postagem.dtos.UsuarioRequestDTO;
import com.redeSocial.postagem.dtos.UsuarioResponseDTO;
import com.redeSocial.postagem.entities.Usuario;
import com.redeSocial.postagem.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Criar usuario
    @PostMapping
    public UsuarioResponseDTO criarUsuario(@RequestBody UsuarioRequestDTO request) {
        Usuario usuario = new Usuario();

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setDataCadastro(request.getDataCadastro());

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuario);
    }

    //Listar usuarios
    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    //Listar usuario por id
    @GetMapping("/{idUsuario}")
    public UsuarioResponseDTO buscarUsuarioPorId(@PathVariable Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        return new UsuarioResponseDTO(usuario);
    }

    @PutMapping("/{idUsuario}")
    public UsuarioResponseDTO editarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioRequestDTO request) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setDataCadastro(request.getDataCadastro());

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public UsuarioResponseDTO removerUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        usuarioRepository.delete(usuario);

        return new UsuarioResponseDTO(usuario);
    }

}
