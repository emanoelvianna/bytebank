package br.com.bytebank.servico;

import br.com.bytebank.modelo.Conta;

import java.math.BigDecimal;

public class ContaServico {
    public BigDecimal depositar(Conta conta, BigDecimal valor) {
        BigDecimal result = conta.getSaldo().add(valor);
        conta.setSaldo(result);
        return result;
    }

    public BigDecimal withdraw(Conta conta, BigDecimal value) {
        BigDecimal result = conta.getSaldo().add(value);
        conta.setSaldo(result);
        return result;
    }

}
