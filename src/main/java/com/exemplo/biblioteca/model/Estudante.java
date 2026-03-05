package com.exemplo.sistemaestudantes.model;

public class Estudante {

    private String matricula;
    private String nome;
    private String curso;
    private int semestre;

    public Estudante(String matricula, String nome, String curso, int semestre) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getSemestre() {
        return semestre;
    }
}