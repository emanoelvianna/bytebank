package br.com.bytebank.modelo;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Cliente implements Autenticavel, Comparable<Cliente> {

    private String nome;
    private String documento;
    private LocalDate dtNascimento;
    private String endereco;
    private String email;
    private String senha;
    private List<Produto> produtos;

    public Cliente(String nome, String documento, LocalDate dtNascimento, String endereco, String email, String senha) {
        this.nome = nome;
        this.documento = documento;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public Boolean autentica(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public int compareTo(Cliente cliente) {
        if (this.dtNascimento.isBefore(cliente.getDtNascimento())) {
            return -1;
        }
        if (this.dtNascimento.isAfter(cliente.getDtNascimento())) {
            return 1;
        }
        return 0;
    }
}
