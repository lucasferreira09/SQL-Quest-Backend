package com.example.SqlQuest.service;

import com.example.SqlQuest.dtos.ConquistaInventarioDTO;
import com.example.SqlQuest.dtos.DicasCompradasDTO;
import com.example.SqlQuest.dtos.ItemInventarioDTO;
import com.example.SqlQuest.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<ItemInventarioDTO> listarPorJogador(Long jogadorId) {
        if (jogadorId == null || jogadorId <= 0) {
            throw new IllegalArgumentException(
                    "O ID do jogador deve ser válido."
            );
        }

        return inventarioRepository.listarPorJogador(jogadorId);
    }


    public List<ConquistaInventarioDTO> listarConquistasPorJogador(Long jogadorId) {

        if (jogadorId == null || jogadorId <= 0) {
            throw new IllegalArgumentException(
                    "O ID do jogador deve ser válido."
            );
        }

        return inventarioRepository.listarConquistasPorJogador(jogadorId);
    }

    public List<DicasCompradasDTO> listarDicasCompradasPorJogador(Long jogadorId) {
        if (jogadorId == null || jogadorId <= 0) {
            throw new IllegalArgumentException("O ID do jogador deve ser válido.");
        }

        return inventarioRepository.listarDicasCompradasPorJogador(jogadorId);
    }
}
