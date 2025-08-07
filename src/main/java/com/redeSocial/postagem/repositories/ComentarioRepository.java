package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByPostagemId(Integer id);
}
