package br.com.bytebank.modelo;

public class Produto<T> {

    private String nome;
    private T produto;

    public Produto(String nome, T produto) {
        this.nome = nome;
        this.produto = produto;
    }

}
