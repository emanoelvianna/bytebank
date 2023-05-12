package br.com.bytebank.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Produto<T> {

    private String nome;
    private T produto;

    public Produto(String nome, T produto) {
        this.nome = nome;
        this.produto = produto;
    }

    public String getNome() {
        return this.nome;
    }

    public T getProduto() {
        return produto;
    }

    public void setProduto(T produto) {
        this.produto = produto;
    }

}
