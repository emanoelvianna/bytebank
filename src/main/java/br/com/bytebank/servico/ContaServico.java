package br.com.bytebank.servico;

import br.com.bytebank.modelo.Autenticavel;
import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.Gerente;

import java.math.BigDecimal;

public class ContaServico {
    public BigDecimal depositar(Autenticavel autenticavel, Conta conta, BigDecimal valor) {
        if(this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(valor);
            conta.setSaldo(result);
            return result;
        }
        return null;
    }

    public BigDecimal sacar(Autenticavel autenticavel, Conta conta, BigDecimal value) {
        if(this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(value);
            conta.setSaldo(result);
            return result;
        }
        return null;
    }

    private Boolean login(Autenticavel autenticavel) {
        String senha = new String("laranja123");
        return autenticavel.autentica(senha);
    }

}
