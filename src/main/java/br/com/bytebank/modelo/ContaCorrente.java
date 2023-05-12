package br.com.bytebank.modelo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

}
