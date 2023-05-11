package br.com.bytebank.modelo;

import java.math.BigDecimal;

public class Operador extends Funcionario {
    private Integer nCaixa;

    public Operador(String nome, String documento, BigDecimal salario, Integer nCaixa) {
        super(nome, documento, salario);
        this.nCaixa = nCaixa;
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
