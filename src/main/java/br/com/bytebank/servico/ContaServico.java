package br.com.bytebank.servico;

import br.com.bytebank.modelo.Autenticavel;
import br.com.bytebank.modelo.Conta;
import br.com.bytebank.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaServico {

    private ContaRepository repository;

    public ContaServico(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta criar() { // TODO: DESENVOLVER
        return null;
    } // TODO: DESENVOLVER

    public Conta getDocumento(String documento) {
        return this.repository.getContaByDocumento(documento);
    }

    public BigDecimal depositar(Autenticavel autenticavel, Conta conta, BigDecimal valor) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(valor);
            conta.setSaldo(result);
            return result;
        }
        return null; // TODO: DEVERIAMOS JOGAR UMA EXCEÇÃO!!!
    }

    public BigDecimal sacar(Autenticavel autenticavel, Conta conta, BigDecimal value) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().subtract(value);
            conta.setSaldo(result);
            return result;
        }
        return null; // TODO: DEVERIAMOS JOGAR UMA EXCEÇÃO!!!
    }

    private Boolean login(Autenticavel autenticavel) {
        String senha = new String("laranja123"); // TODO: SENHA DE ENTRADA
        return autenticavel.autentica(senha);
    }
}
