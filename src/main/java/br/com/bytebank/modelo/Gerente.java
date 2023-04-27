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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
