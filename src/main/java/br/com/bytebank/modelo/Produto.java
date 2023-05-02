package br.com.bytebank.modelo;

public class Produto<T> {

    private T produto;

    public Produto(String nome, T produto) {
        this.produto = produto;
    }

    public Produto(Consignado matera) {
    }

    public Produto(Finciamento finciamento) {
    }

    public Produto(Credito credito) {
    }

    public T getProduto() {
        return produto;
    }

    public void setProduto(T produto) {
        this.produto = produto;
    }

}
