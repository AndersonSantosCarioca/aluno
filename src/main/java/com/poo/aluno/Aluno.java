package com.poo.aluno;

import java.util.Date;

public class Aluno {

    private static int contador = 1;
    private String nome;
    private Date dataNascimento;
    private int matricula;

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = contador;
        contador++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }
}
