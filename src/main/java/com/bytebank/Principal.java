package com.bytebank;


import com.bytebank.model.Conta;
import com.bytebank.model.Cliente;
import com.bytebank.service.ContaServico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Cliente emanoel = new Cliente("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com");
        Conta conta = new Conta(emanoel);

        ContaServico service = new ContaServico();
        service.depositar(conta, new BigDecimal(100));

        System.out.println(conta.toString());
    }

}