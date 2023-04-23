package br.com.bytebank.servico;

import br.com.bytebank.modelo.Conta;

import java.math.BigDecimal;

public class ContaServico {
    public BigDecimal depositar(Conta conta, BigDecimal valor) {
        BigDecimal resultado = conta.getSaldo().add(valor);
        conta.setSaldo(resultado);
        return resultado;
    }

    public BigDecimal sacar(Conta conta, BigDecimal valor) {
        BigDecimal resultado = conta.getSaldo().add(valor);
        conta.setSaldo(resultado);
        return resultado;
    }

}
