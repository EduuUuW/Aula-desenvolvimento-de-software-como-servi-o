package com.exemplo.sistemaestudantes.controller;

import com.exemplo.sistemaestudantes.model.Estudante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/busca")
public class BuscaController {

    private List<Estudante> estudantes = new ArrayList<>();

    public BuscaController() {

        estudantes.add(new Estudante("2024001", "Carlos Silva", "Engenharia de Software", 3));
        estudantes.add(new Estudante("2024002", "Ana Souza", "Ciência da Computação", 2));
        estudantes.add(new Estudante("2024003", "Lucas Pereira", "Sistemas de Informação", 5));
    }

    @GetMapping("/curso/{curso}")
    public List<Estudante> buscarPorCurso(@PathVariable String curso) {

        List<Estudante> resultado = new ArrayList<>();

        for (Estudante e : estudantes) {
            if (e.getCurso().equalsIgnoreCase(curso)) {
                resultado.add(e);
            }
        }

        return resultado;
    }
}