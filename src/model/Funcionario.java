package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class Funcionario extends Pessoa implements Comparator<Funcionario> {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
        super(nome, dataDeNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    // Calcula o bônus baseado na %.
    public void bonus(BigDecimal bonificacao){
        BigDecimal bonus = this.getSalario().multiply(bonificacao);
        this.salario = this.salario.add(bonus);
    }

    public String funcionarioMaisVelho(){
        return super.toString();
    }

    // Faz a comparação das pessoas com base na data de nascimento.
    @Override
    public int compareTo(Pessoa p) {
        return this.getDataDeNascimento().compareTo(p.getDataDeNascimento());
    }

    // Uso a interface Comparator para fazer a comparação com base no nome.
    @Override
    public int compare(Funcionario f1, Funcionario f2) {
        return f1.getNome().compareTo(f2.getNome());
    }

    @Override
    public String toString() {
        return super.toString() + " - Salário - " + this.salario + " - Função - " + this.funcao;
    }

}
