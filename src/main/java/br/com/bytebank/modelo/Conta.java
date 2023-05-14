package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Conta {

    private Cliente cliente;
    private BigDecimal saldo;
    private LocalDate dtCriacao;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
        this.dtCriacao = LocalDate.now();
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
