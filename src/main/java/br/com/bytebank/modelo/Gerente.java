package br.com.bytebank.modelo;

import java.math.BigDecimal;

public class Gerente extends Funcionario implements Autenticavel {

    private String senha;

    public Gerente(String nome, String documento, BigDecimal salario, String senha) {
        super(nome, documento, salario);
        this.senha = senha;
    }

    @Override
    public Boolean autentica(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        if (this.getSalario().compareTo(funcionario.getSalario()) < 0) {
            return 1;
        } else if (this.getSalario().compareTo(funcionario.getSalario()) > 0) {
            return -1;
        }
        return 0;
    }
}
