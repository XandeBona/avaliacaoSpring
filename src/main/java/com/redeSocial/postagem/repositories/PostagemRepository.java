package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
    List<Postagem> findByUsuarioId(Integer id);
}
