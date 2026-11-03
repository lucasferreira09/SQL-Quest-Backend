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

    public DicaController(DicaService dicaService) {
        this.dicaService = dicaService;
    }

    // Buscar dicas de um desafio
    @GetMapping("/desafio/{desafioId}")
    public ResponseEntity<?> buscarDicas(@PathVariable int desafioId, @RequestParam int jogadorId) {

        return ResponseEntity.ok(
                dicaService.buscarDicas(jogadorId, desafioId)
        );
    }

    // Consultar saldo de ouro
    @GetMapping("/ouro")
    public ResponseEntity<?> buscarOuro(@RequestParam int jogadorId) {

        return ResponseEntity.ok(
                dicaService.buscarOuro(jogadorId)
        );
    }

    // Comprar uma dica
    @PostMapping("/comprar")
    public ResponseEntity<?> comprarDica(@RequestBody Map<String, Integer> dados) {

        Integer dicaId = dados.get("dicaId");
        Integer jogadorId = dados.get("jogadorId");

        if (dicaId == null || jogadorId == null || jogadorId <= 0) {
            Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", "ID da dica e do jogador são obrigatórios.");
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