package br.com.bytebank.servico;

import br.com.bytebank.modelo.Autenticavel;
import br.com.bytebank.modelo.Conta;

import java.math.BigDecimal;

public class ContaServico {

    public BigDecimal depositar(Autenticavel autenticavel, Conta conta, BigDecimal valor) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(valor);
            conta.setSaldo(result);
            return result;
        }
        return null; // TODO: MELHORAR!
    }

    public BigDecimal sacar(Autenticavel autenticavel, Conta conta, BigDecimal value) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(value);
            conta.setSaldo(result);
            return result;
        }
        return null;
    }

    private Boolean login(Autenticavel autenticavel) {
        String senha = new String("laranja123"); // TODO: SENHA DE ENTRADA
        return autenticavel.autentica(senha);
    }
}
