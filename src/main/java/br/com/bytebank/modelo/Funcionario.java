package br.com.bytebank.modelo;

import java.math.BigDecimal;

public abstract class Funcionario implements Comparable <Funcionario> {

    private String nome;
    private String documento;
    private BigDecimal salario;

    public Funcionario(String nome, String documento, BigDecimal salario) {
        this.nome = nome;
        this.documento = documento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }
    @Override
    public int compareTo(Funcionario funcionario) {
        if (this.salario.compareTo(funcionario.getSalario()) < 0) {
            return -1;
        } else if (this.salario.compareTo(funcionario.getSalario()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

