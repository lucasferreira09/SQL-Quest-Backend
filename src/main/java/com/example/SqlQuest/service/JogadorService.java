
package com.example.SqlQuest.service;

import com.example.SqlQuest.model.Jogador;
import com.example.SqlQuest.repository.JogadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }


    @Transactional
    public Jogador entrar(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Informe o nome do jogador."
            );
        }

        final String nomeNormalizado = nome.trim();

        return jogadorRepository.findByNomeIgnoreCase(nomeNormalizado)
                .orElseGet(() -> {

                    Jogador novoJogador = new Jogador();
                    novoJogador.setNome(nomeNormalizado);

                    return jogadorRepository.save(novoJogador);
                });
    }

}
