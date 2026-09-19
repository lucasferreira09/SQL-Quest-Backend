package com.example.SqlQuest.controller;

import com.example.SqlQuest.service.ProgressoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progresso")
@CrossOrigin(origins = "*")
public class ProgressoController {

    private final ProgressoService progressoService;

    public ProgressoController(ProgressoService progressoService) {
        this.progressoService = progressoService;
    }

    @GetMapping("/jogador/{jogadorId}")
    public List<Integer> buscarDesafiosConcluidos(@PathVariable int jogadorId) {

        return progressoService.buscarDesafiosConcluidos(jogadorId);
    }
}