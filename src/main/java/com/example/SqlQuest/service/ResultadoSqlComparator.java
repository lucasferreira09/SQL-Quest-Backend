package com.example.SqlQuest.service;

import com.example.SqlQuest.dtos.ResultadoSql;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ResultadoSqlComparator {

    public boolean comparar(
            ResultadoSql resultadoJogador,
            ResultadoSql resultadoEsperado,
            boolean ordemImporta
    ) {

        if (resultadoJogador.getColunas().size() != resultadoEsperado.getColunas().size()) {
            return false;
        }

        if (resultadoJogador.getLinhas().size() != resultadoEsperado.getLinhas().size()) {
            return false;
        }


        for (int i = 0; i < resultadoJogador.getColunas().size(); i++) {

            String colunaJogador = resultadoJogador.getColunas().get(i).toLowerCase();

            String colunaEsperada = resultadoEsperado.getColunas().get(i).toLowerCase();

            if (!colunaJogador.equals(colunaEsperada)) {
                return false;
            }
        }

        // Cria cópias para poder ordenar sem alterar
        // os resultados originais.
        List<List<Object>> jogador = new ArrayList<>(resultadoJogador.getLinhas());

        List<List<Object>> esperado = new ArrayList<>(resultadoEsperado.getLinhas());


        // Quando a ordem não importa, ordenamos as linhas antes de comparar.
        if (!ordemImporta) {

            Comparator<List<Object>> comparator = Comparator.comparing(this::representacaoLinha);

            jogador.sort(comparator);
            esperado.sort(comparator);
        }

        // Compara linha por linha
        for (int i = 0; i < jogador.size(); i++) {

            if (!linhasIguais(jogador.get(i), esperado.get(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean linhasIguais(List<Object> linhaJogador, List<Object> linhaEsperada) {

        if (linhaJogador.size() != linhaEsperada.size()) {
            return false;
        }

        for (int i = 0; i < linhaJogador.size(); i++) {

            Object jogador = normalizarValor(linhaJogador.get(i));

            Object esperado = normalizarValor(linhaEsperada.get(i));

            if (jogador == null && esperado == null) {
                continue;
            }

            if (jogador == null || esperado == null) {
                return false;
            }

            if (!jogador.equals(esperado)) {
                return false;
            }
        }
        return true;
    }

    private Object normalizarValor(Object valor) {

        if (valor == null) {
            return null;
        }

        if (valor instanceof Number numero) {
            return numero.doubleValue();
        }

        return valor.toString();
    }

    private String representacaoLinha(List<Object> linha) {

        return linha
                .stream()
                .map(valor -> String.valueOf(normalizarValor(valor)))
                .toList()
                .toString();
    }
}