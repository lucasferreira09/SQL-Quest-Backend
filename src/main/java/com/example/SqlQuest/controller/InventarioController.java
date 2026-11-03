package com.example.SqlQuest.controller;

import com.example.SqlQuest.dtos.ConquistaInventarioDTO;
import com.example.SqlQuest.dtos.DicasCompradasDTO;
import com.example.SqlQuest.dtos.ItemInventarioDTO;
import com.example.SqlQuest.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    private final InventarioService inventarioService;

    @GetMapping
    public List<ItemInventarioDTO> listarPorJogador(
            @RequestParam Long jogadorId) {

        return inventarioService.listarPorJogador(jogadorId);
    }

    @GetMapping("/conquistas")
    public List<ConquistaInventarioDTO> listarConquistas(
            @RequestParam Long jogadorId
    ) {
        return inventarioService.listarConquistasPorJogador(jogadorId);
    }

    @GetMapping("/dicas")
    public List<DicasCompradasDTO> listarDicasCompradas(
            @RequestParam Long jogadorId
    ) {
        return inventarioService.listarDicasCompradasPorJogador(jogadorId);
    }



}
