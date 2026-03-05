package com.exemplo.sistemaestudantes.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private Map<Integer, String> cursos = new HashMap<>();

    public CursoController() {
        cursos.put(1, "Engenharia de Software");
        cursos.put(2, "Ciência da Computação");
        cursos.put(3, "Sistemas de Informação");
        cursos.put(4, "Análise e Desenvolvimento de Sistemas");
        cursos.put(5, "Banco de Dados");
    }

    @GetMapping
    public Map<Integer, String> listarCursos() {
        return cursos;
    }

    @GetMapping("/{id}")
    public String buscarCurso(@PathVariable Integer id) {

        if (!cursos.containsKey(id)) {
            return "Curso não encontrado";
        }

        return cursos.get(id);
    }
}