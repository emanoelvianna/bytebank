package br.com.bytebank.modelo;

import java.math.BigDecimal;

public class Produto<T> {

    private T produto;

    public T getProduto() {
        return produto;
    }

    public void setProduto(T produto) {
        this.produto = produto;
    }

}
