package com.example.SqlQuest.controller;

import com.example.SqlQuest.service.DicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dicas")
@CrossOrigin(origins = "http://localhost:4200")
public class DicaController {

    private final DicaService dicaService;

    // ID temporário do jogador, seguindo o padrão atual do projeto.
    private final int jogadorId = 1;

    public DicaController(DicaService dicaService) {
        this.dicaService = dicaService;
    }

    // Buscar dicas de um desafio
    @GetMapping("/desafio/{desafioId}")
    public ResponseEntity<?> buscarDicas(@PathVariable int desafioId) {

        return ResponseEntity.ok(
                dicaService.buscarDicas(jogadorId, desafioId)
        );
    }

    // Consultar saldo de ouro
    @GetMapping("/ouro")
    public ResponseEntity<?> buscarOuro() {

        return ResponseEntity.ok(
                dicaService.buscarOuro(jogadorId)
        );
    }

    // Comprar uma dica
    @PostMapping("/comprar")
    public ResponseEntity<?> comprarDica(@RequestBody Map<String, Integer> dados) {

        Integer dicaId = dados.get("dicaId");

        if (dicaId == null) {
            Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", "O ID da dica é obrigatório.");
            return ResponseEntity.badRequest().body(erro);
        }

        try {
            return ResponseEntity.ok(
                    dicaService.comprarDica(jogadorId, dicaId)
            );

        } catch (IllegalArgumentException | IllegalStateException e) {

            Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", e.getMessage());

            return ResponseEntity.badRequest().body(erro);
        }
    }
}