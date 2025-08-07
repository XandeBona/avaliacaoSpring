package com.redeSocial.postagem.repositories;

import com.redeSocial.postagem.entities.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
}
