package br.com.bytebank;


import br.com.bytebank.modelo.*;
import br.com.bytebank.servico.ContaServico;
import br.com.bytebank.servico.IRServico;
import br.com.bytebank.servico.ProdutoServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Principal {

    public static void main(String[] args) {
        Cliente emanoel = new Cliente("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com", "laranja123");
        Conta conta = new ContaCorrente(emanoel);
        conta.setSaldo(new BigDecimal(1000)); // TODO: REMOVER MÉTODO SET

        System.out.println(conta.toString());

        ContaServico servico = new ContaServico();
        servico.depositar(emanoel, conta, new BigDecimal(100));

        System.out.println(conta.toString());

        Gerente gerente = new Gerente("Pedro Silva",
                "896.933.390-88",
                new BigDecimal(5000),
                "laranja123");

        IRServico irServico = new IRServico();
        irServico.calcularIR(gerente);

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