
package com.example.SqlQuest.controller;

import com.example.SqlQuest.model.Jogador;
import com.example.SqlQuest.service.JogadorService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jogadores")
@CrossOrigin(origins = "*")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping("/entrar")
    public Jogador entrar(@RequestBody JogadorRequest request) {
        return jogadorService.entrar(request.nome());
    }

    public record JogadorRequest(String nome) {}
}
