package com.example.SqlQuest.repository;


import com.example.SqlQuest.model.DicaComprada;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DicaCompradaRepository
        extends JpaRepository<DicaComprada, Long> {

    boolean existsByJogadorIdAndDicaId(
            Long jogadorId,
            Long dicaId
    );

    Optional<DicaComprada> findByJogadorIdAndDicaId(
            Long jogadorId,
            Long dicaId
    );

    List<DicaComprada> findByJogadorId(Long jogadorId);
}