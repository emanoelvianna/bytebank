package br.com.bytebank.modelo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Consignado {

    private BigDecimal margem;
    private BigDecimal valor;
    private String empregador;

    public Consignado(BigDecimal margem, BigDecimal valor, String empregador) {
        this.margem = margem;
        this.valor = valor;
        this.empregador = empregador;
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

    public String getEmpregador() {
        return empregador;
    }

    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }
}
