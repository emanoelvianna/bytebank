package br.com.bytebank;


import br.com.bytebank.modelo.*;
import br.com.bytebank.servico.ContaServico;
import br.com.bytebank.servico.IRServico;
import br.com.bytebank.servico.ProdutoSerivo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Cliente emanoel = new Cliente("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com", "laranja123");
        Conta conta = new Conta(emanoel);
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
        ProdutoSerivo produtoSerivo = new ProdutoSerivo();
        produtoSerivo.adicionarProduto(consignado);
        produtoSerivo.adicionarProduto(finciamento);

        produtoSerivo.listar();
    }

}