package br.com.bytebank.modelo;

public class Produto<T> {

    private T produto;

    public Produto(T produto) {
        this.produto = produto;
    }

    public T getProduto() {
        return produto;
    }

    public void setProduto(T produto) {
        this.produto = produto;
    }

}
