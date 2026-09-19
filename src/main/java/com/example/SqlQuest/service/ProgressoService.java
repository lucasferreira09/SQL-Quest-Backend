package com.example.SqlQuest.service;

import com.example.SqlQuest.repository.ProgressoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressoService {

    private final ProgressoRepository progressoRepository;

    public ProgressoService(ProgressoRepository progressoRepository) {
        this.progressoRepository = progressoRepository;
    }

    public List<Integer> buscarDesafiosConcluidos(int jogadorId) {

        return progressoRepository.buscarDesafiosConcluidos(jogadorId);
    }

    public void concluirDesafio(int jogadorId, int desafioId) {

        progressoRepository.concluirDesafio(
                jogadorId,
                desafioId
        );
    }

    public boolean desafioConcluido(int jogadorId, int desafioId) {

        return progressoRepository.desafioConcluido(
                jogadorId,
                desafioId
        );
    }
}