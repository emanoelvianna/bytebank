package br.com.bytebank.modelo;

import org.springframework.stereotype.Component;

@Component
public interface Autenticavel {

    Boolean autentica(String senha);

}
