package br.com.bytebank.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca(Cliente cliente, BigDecimal saldo, LocalDate dtCriacao) {
        super(cliente, saldo, dtCriacao);
    }
}
