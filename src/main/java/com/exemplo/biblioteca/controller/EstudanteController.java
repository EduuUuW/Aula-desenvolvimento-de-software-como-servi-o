package com.exemplo.sistemaestudantes.controller;

import com.exemplo.sistemaestudantes.model.Estudante;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    private Map<String, Estudante> estudantes = new HashMap<>();

    public EstudanteController() {

        estudantes.put("2024001",
                new Estudante("2024001", "Carlos Silva", "Engenharia de Software", 3));

        estudantes.put("2024002",
                new Estudante("2024002", "Ana Souza", "Ciência da Computação", 2));

        estudantes.put("2024003",
                new Estudante("2024003", "Lucas Pereira", "Sistemas de Informação", 5));
    }

    @GetMapping("/{matricula}")
    public Estudante buscarEstudante(@PathVariable String matricula) {

        if (!estudantes.containsKey(matricula)) {
            throw new RuntimeException("Estudante não encontrado");
        }

        return estudantes.get(matricula);
    }
}