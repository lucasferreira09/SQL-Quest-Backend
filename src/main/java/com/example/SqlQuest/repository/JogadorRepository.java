
package com.example.SqlQuest.repository;

import com.example.SqlQuest.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    Optional<Jogador> findByNomeIgnoreCase(String nome);

}
