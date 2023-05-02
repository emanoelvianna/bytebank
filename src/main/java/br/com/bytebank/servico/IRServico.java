package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;

import java.math.BigDecimal;

public class IRServico {

    public static BigDecimal calcularIR(Funcionario funcionario) {
        return funcionario.getSalario().multiply(new BigDecimal(12));
    }

}
