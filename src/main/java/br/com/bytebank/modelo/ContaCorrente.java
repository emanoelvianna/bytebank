package br.com.bytebank.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(Cliente cliente, BigDecimal saldo, LocalDate dtCriacao) {
        super(cliente, saldo, dtCriacao);
    }
}
