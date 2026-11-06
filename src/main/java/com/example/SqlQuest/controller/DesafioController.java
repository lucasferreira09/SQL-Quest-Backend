package com.example.SqlQuest.controller;

import com.example.SqlQuest.dtos.*;
import com.example.SqlQuest.service.DesafioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desafios")
@CrossOrigin(origins = "*")
public class DesafioController {

    private final DesafioService desafioService;

    public DesafioController(DesafioService desafioService) {
        this.desafioService = desafioService;
    }

    @PostMapping("/{id}/preview")
    public ResponseEntity<PreviewSqlResponse> preview(
            @PathVariable int id,
            @RequestBody ExecutarSqlRequest request
    ) {

        if (request.getJogadorId() == null || request.getJogadorId() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        PreviewSqlResponse resposta = desafioService.preview(
                id,
                request.getJogadorId(),
                request.getSql()
        );

        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/{id}/executar")
    public ResponseEntity<ExecutarSqlResponse> executar(
            @PathVariable int id,
            @RequestBody ExecutarSqlRequest request
    ) {

        if (request.getJogadorId() == null || request.getJogadorId() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        ExecutarSqlResponse resposta = desafioService.executar(
                id,
                request.getJogadorId(),
                request.getSql()
        );

        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/capitulo/{capituloId}")
    public List<DesafioResponse> listarPorCapitulo(@PathVariable int capituloId) {

        return desafioService.listarPorCapitulo(capituloId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesafioResponse> buscarDesafio(
            @PathVariable int id) {

        try {
            DesafioResponse desafio = desafioService.buscarDesafio(id);
            return ResponseEntity.ok(desafio);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/blocos")
    public List<BlocoDesafioResponse> listarBlocos(
            @PathVariable int id) {

        return desafioService.listarBlocos(id);
    }
}