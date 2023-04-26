package br.com.bytebank.servico;

import br.com.bytebank.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoServico {

    private List<Produto> produtos;

    public ProdutoServico() {
        this.produtos = new ArrayList<>();
    }

    public Boolean adicionarProduto(Produto produto) {
        return this.produtos.add(produto);
    }

    public List<Produto> listar() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
