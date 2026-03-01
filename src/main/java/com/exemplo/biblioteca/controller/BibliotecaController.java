package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.BibliotecaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class BibliotecaController {

    private final BibliotecaRepository repository;

    public BibliotecaController(BibliotecaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @GetMapping("/buscar")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return repository.findByTitulo(titulo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔥 NOVO 1 - Atualizar livro
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {

        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setIsbn(livroAtualizado.getIsbn());
        livro.setDisponivel(livroAtualizado.getDisponivel());

        return repository.save(livro);
    }

    // 🔥 NOVO 2 - Listar disponíveis
    @GetMapping("/disponiveis")
    public List<Livro> listarDisponiveis() {
        return repository.findAll().stream()
                .filter(livro -> Boolean.TRUE.equals(livro.getDisponivel()))
                .toList();
    }

    // 🔥 NOVO 3 - Alterar disponibilidade
    @PatchMapping("/{id}/disponibilidade")
    public Livro alterarDisponibilidade(@PathVariable Long id,
                                        @RequestParam Boolean disponivel) {

        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setDisponivel(disponivel);

        return repository.save(livro);
    }
}