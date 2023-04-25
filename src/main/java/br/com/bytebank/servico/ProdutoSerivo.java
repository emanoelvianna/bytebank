package br.com.bytebank.servico;

import br.com.bytebank.modelo.Consignado;
import br.com.bytebank.modelo.Finciamento;
import br.com.bytebank.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoSerivo {

    private List<Produto> produtos;

    public ProdutoSerivo() {
        this.produtos = new ArrayList<>();
    }

    public Boolean adicionarProduto(Produto produto) {
        return this.produtos.add(produto);
    }

    public List<Produto> listar() {
        return this.produtos;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
