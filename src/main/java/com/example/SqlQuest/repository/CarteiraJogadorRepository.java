package com.example.SqlQuest.repository;

import com.example.SqlQuest.model.CarteiraJogador;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.util.Optional;

public interface CarteiraJogadorRepository
        extends JpaRepository<CarteiraJogador, Long> {

    Optional<CarteiraJogador> findByJogadorId(Long jogadorId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT c FROM CarteiraJogador c
        WHERE c.jogadorId = :jogadorId
    """)
    Optional<CarteiraJogador> buscarCarteiraParaAtualizacao(
            @Param("jogadorId") Long jogadorId
    );
}