package br.com.bytebank.modelo;

import org.springframework.stereotype.Component;

@Component
public interface Autenticavel {

    public Boolean autentica(String senha);

}
