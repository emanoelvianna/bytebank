package br.com.bytebank.servico;

import br.com.bytebank.modelo.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

}
