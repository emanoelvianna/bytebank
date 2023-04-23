package br.com.bytebank.modelo;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String documento;
    private LocalDate dtNascimento;
    private String endereco;
    private String email;

    public Cliente(String nome, String documento, LocalDate dtNascimento, String endereco, String email) {
        this.nome = nome;
        this.documento = documento;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.email = email;
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

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
