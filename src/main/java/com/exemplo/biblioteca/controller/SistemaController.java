package com.exemplo.sistemaestudantes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SistemaController {

    @GetMapping("/api/sistema/info")
    public Map<String, String> infoSistema() {

        Map<String, String> info = new HashMap<>();

        info.put("nome", "Sistema de Estudantes");
        info.put("versao", "1.0");
        info.put("java", System.getProperty("java.version"));
        info.put("dataHora", LocalDateTime.now().toString());
        info.put("status", "operacional");

        return info;
    }
}