package br.com.bytebank.modelo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

}
