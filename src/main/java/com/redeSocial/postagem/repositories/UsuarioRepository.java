package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
