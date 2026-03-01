package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor cadastrar(@RequestBody Autor autor) {
        return repository.save(autor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔥 NOVO 1 - Atualizar
    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autor.setNome(autorAtualizado.getNome());
        autor.setNacionalidade(autorAtualizado.getNacionalidade());
        autor.setDataNascimento(autorAtualizado.getDataNascimento());

        return repository.save(autor);
    }

    // 🔥 NOVO 2 - Buscar por nome
    @GetMapping("/buscar")
    public List<Autor> buscarPorNome(@RequestParam String nome) {
        return repository.findByNome(nome);
    }

    // 🔥 NOVO 3 - Contar autores
    @GetMapping("/quantidade")
    public int contarAutores() {
        return repository.findAll().size();
    }
}