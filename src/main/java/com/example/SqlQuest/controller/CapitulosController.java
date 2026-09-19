package com.example.SqlQuest.controller;

import com.example.SqlQuest.dtos.CapituloResponse;
import com.example.SqlQuest.service.CapitulosService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/capitulos")
@CrossOrigin(origins = "*")
public class CapitulosController {

    private final CapitulosService capitulosService;

    public CapitulosController(CapitulosService capitulosService) {
        this.capitulosService = capitulosService;
    }

    @GetMapping
    public List<CapituloResponse> listarCapitulos() {
        return capitulosService.listarCapitulos();
    }
}