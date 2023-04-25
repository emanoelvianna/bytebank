package br.com.bytebank;


import br.com.bytebank.modelo.*;
import br.com.bytebank.servico.ContaServico;
import br.com.bytebank.servico.IRServico;
import br.com.bytebank.servico.ProdutoService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Cliente emanoel = new Cliente("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com", "laranja123");
        ContaCorrente conta = new ContaCorrente(emanoel);
        conta.setSaldo(new BigDecimal(1000));

        ContaServico servico = new ContaServico();
        servico.depositar(emanoel, conta, new BigDecimal(100));

        System.out.println(conta.toString());

        Gerente gerente = new Gerente("Pedro Silva",
                "896.933.390-88",
                new BigDecimal(5000),
                "laranja123");

        IRServico irServico = new IRServico();
        irServico.calcularIR(gerente);

        Produto<Consignado> consignado = new Produto<>();
        Produto<Finciamento> finciamento = new Produto<>();
        ProdutoService produtoService = new ProdutoService();
        produtoService.adicionarProduto(consignado);
        produtoService.adicionarProduto(finciamento);

        produtoService.listar();

        // TESTES Exercicio

        Cliente teste = new Cliente("teste",
                "142.135.090-44",
                LocalDate.of(1981, 9, 12),
                "2345678",
                "teste@gmail.com", "teste123");
        ContaCorrente testeCorrente = new ContaCorrente(teste);
        conta.setSaldo(new BigDecimal(1000));
        Produto<Emprestimo> Emprestimo = new Produto<>();
        produtoService.adicionarProduto(Emprestimo);

    }

}