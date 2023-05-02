package br.com.bytebank;


import br.com.bytebank.modelo.*;
import br.com.bytebank.servico.ContaServico;
import br.com.bytebank.servico.IRServico;
import br.com.bytebank.servico.ProdutoServico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        // criando o funcionario
        Gerente gerente = new Gerente("Pedro Silva",
                "896.933.390-88",
                new BigDecimal(5000),
                "laranja123");

        // criando o cliente
        Cliente emanoel = new Cliente("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com", "laranja123");
        // criando a conta relacionada com o cliente
        Conta conta = new ContaCorrente(emanoel);
        System.out.println(conta.toString());

        // criando o serviço responsável em gerenciar a conta
        ContaServico contaServico = new ContaServico();
        contaServico.depositar(emanoel, conta, new BigDecimal(100));
        System.out.println(conta.toString());

        // calculando o imposto de renda do funcionario
        IRServico irServico = new IRServico();
        irServico.calcularIR(gerente);

        // criando a lista de produtos
        ProdutoServico produtoServico = new ProdutoServico();
        Consignado consignado = new Consignado(new BigDecimal(500), new BigDecimal(500), "Matera");
        Produto<Consignado> pConsignado = new Produto<>("Consignado", consignado);
        produtoServico.adicionarProduto(pConsignado);

        Finciamento finciamento = new Finciamento(new BigDecimal(500), new BigDecimal(200));
        Produto<Finciamento> pFinciamento = new Produto<>("Finciamento", finciamento);
        produtoServico.adicionarProduto(pFinciamento);

        Credito credito = new Credito(new BigDecimal(500), new BigDecimal(200));
        Produto<Credito> pCredito = new Produto<>("Credito", credito);
        produtoServico.adicionarProduto(pCredito);

    }

}