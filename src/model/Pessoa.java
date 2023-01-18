package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa implements Comparable<Pessoa>{

    private String nome;
    private LocalDate dataDeNascimento;

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + " - Data de Nascimento: " + dataDeNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
