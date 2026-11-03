
package com.example.SqlQuest.service;

import com.example.SqlQuest.repository.DicaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class DicaService {

    private final DicaRepository dicaRepository;

    public DicaService(DicaRepository dicaRepository) {
        this.dicaRepository = dicaRepository;
    }

    // =====================================================
    // LISTAR DICAS DO DESAFIO
    // =====================================================

    public List<Map<String, Object>> buscarDicas(
            int jogadorId,
            int desafioId) {

        return dicaRepository.buscarDicas(
                jogadorId,
                desafioId
        );
    }

    // =====================================================
    // CONSULTAR OURO
    // =====================================================

    public Map<String, Object> buscarOuro(int jogadorId) {

        int ouro = dicaRepository.buscarOuro(jogadorId);

        Map<String, Object> resposta = new HashMap<>();

        resposta.put("ouro", ouro);

        return resposta;
    }

    // =====================================================
    // COMPRAR DICA
    // =====================================================

    @Transactional
    public Map<String, Object> comprarDica(int jogadorId, int dicaId) {

        // Verifica se a dica existe
        Map<String, Object> dica;

        try {
            dica = dicaRepository.buscarDica(dicaId);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new IllegalArgumentException(
                    "Dica não encontrada."
            );
        }

        int desafioId = ((Number) dica.get("DESAFIO_ID")).intValue();

        int custoOuro = ((Number) dica.get("CUSTO_OURO")).intValue();

        // Verifica se já foi comprada
        if (dicaRepository.dicaComprada(jogadorId, dicaId)) {
            throw new IllegalStateException(
                    "Você já comprou esta dica."
            );
        }

        // Verifica se o jogador possui ouro suficiente
        boolean descontado = dicaRepository.descontarOuro(
                jogadorId,
                custoOuro
        );

        if (!descontado) {
            throw new IllegalArgumentException(
                    "Ouro insuficiente."
            );
        }

        // Registra a compra
        dicaRepository.registrarCompra(
                jogadorId,
                dicaId,
                desafioId
        );

        // Consulta o saldo atualizado
        int ouroAtual = dicaRepository.buscarOuro(jogadorId);

        Map<String, Object> resposta = new HashMap<>();

        resposta.put("mensagem", "Dica comprada com sucesso!");
        resposta.put("dicaId", dicaId);
        resposta.put("desafioId", desafioId);
        resposta.put("texto", dica.get("TEXTO"));
        resposta.put("ouroAtual", ouroAtual);

        return resposta;
    }
}
