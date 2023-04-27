package br.com.bytebank;


import br.com.bytebank.modelo.*;
import br.com.bytebank.servico.ContaServico;
import br.com.bytebank.servico.FuncionarioServico;
import br.com.bytebank.servico.IRServico;
import br.com.bytebank.servico.ProdutoServico;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Principal {

    public static void main(String[] args) {
//        Cliente emanoel = new Cliente("Emanoel Vianna",
//                "142.135.090-44",
//                LocalDate.of(1993, 1, 22),
//                "91270-010",
//                "vianna@gmail.com", "laranja123");
//        Conta conta = new ContaCorrente(emanoel);
//        conta.setSaldo(new BigDecimal(1000)); // TODO: REMOVER MÉTODO SET
//
//        System.out.println(conta.toString());
//
//        ContaServico servico = new ContaServico();
//        servico.depositar(emanoel, conta, new BigDecimal(100));
//
//        System.out.println(conta.toString());
//
//        Gerente gerente = new Gerente("Pedro Silva",
//                "896.933.390-88",
//                new BigDecimal(5000),
//                "laranja123");
//
//        IRServico irServico = new IRServico();
//        irServico.calcularIR(gerente);
//
//        Produto<Consignado> consignado = new Produto<>(new Consignado(new BigDecimal(500), new BigDecimal(500), "Matera"));
//        Produto<Finciamento> finciamento = new Produto<>(new Finciamento(new BigDecimal(500), new BigDecimal(200)));
//        Produto<Credito> credito = new Produto<>(new Credito(new BigDecimal(500), new BigDecimal(200)));
//        ProdutoServico produtoServico = new ProdutoServico();
//        produtoServico.adicionarProduto(consignado);
//        produtoServico.adicionarProduto(finciamento);
//        produtoServico.adicionarProduto(credito);
//
//        List<Cliente> clientes = new ArrayList<>();
//        clientes.add(emanoel);
//
//        Optional<Cliente> clienteEmanoel = Optional.of(emanoel);
//        clienteEmanoel.ifPresent(c -> c.getDocumento());
//
//        if (emanoel != null) {
//            emanoel.getDocumento();
//        }


        FuncionarioServico fservico = new FuncionarioServico();

        Operador f1 = new Operador("João", "111.222.333-44", new BigDecimal("5000"), 1);
        Operador f2 = new Operador("Maria", "222.333.444-55", new BigDecimal("5000"), 2);
        Gerente f3 = new Gerente("Pedro", "333.444.555-66", new BigDecimal("15000"), "123deoliveira4");

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);

//        //Modo antigo
//        for (Funcionario f : funcionarios) {
//            System.out.println(f.getNome());
//        }

        // Modo forEACH
        funcionarios.stream().forEach(funcionario -> System.out.println(funcionario));

        Optional<Funcionario> funcionarioF1 = Optional.of(f1);
        funcionarioF1.ifPresent(f -> System.out.printf("Funcionário %s está presente.%n", f.getDocumento()));
    }
}