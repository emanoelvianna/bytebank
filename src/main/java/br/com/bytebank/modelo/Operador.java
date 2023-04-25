package br.com.bytebank.modelo;

import java.math.BigDecimal;

public class Operador extends Funcionario {
    private Integer nCaixa;

    public Operador(String nome, String documento, BigDecimal salario, Integer nCaixa) {
        super(nome, documento, salario);
        this.nCaixa = nCaixa;
    }

    public Integer getnCaixa() {
        return nCaixa;
    }

    public void setnCaixa(Integer nCaixa) {
        this.nCaixa = nCaixa;
    }
}
