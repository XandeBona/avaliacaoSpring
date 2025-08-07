package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
    List<Curtida> findByPostagemId(Integer id);
}
