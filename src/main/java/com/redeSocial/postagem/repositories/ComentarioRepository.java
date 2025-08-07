package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    Comentario buscarPostagemById(Integer idPostagem);
}
