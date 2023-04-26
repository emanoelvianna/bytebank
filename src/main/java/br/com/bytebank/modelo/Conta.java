package br.com.bytebank.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    private Cliente cliente;
    private BigDecimal saldo;
    private LocalDate dtCriacao;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
        this.dtCriacao = LocalDate.now();
    }

    public Conta(Cliente cliente, BigDecimal saldo, LocalDate dtCriacao) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.dtCriacao = dtCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente.getNome() +
                ", saldo=" + saldo +
                ", dtCriacao=" + dtCriacao +
                '}';
    }
}
