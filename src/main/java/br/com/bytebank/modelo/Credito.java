package br.com.bytebank.modelo;

import java.math.BigDecimal;

public class Credito {

    private BigDecimal margem;
    private BigDecimal valor;

    public Credito(BigDecimal margem, BigDecimal valor) {
        this.margem = margem;
        this.valor = valor;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
