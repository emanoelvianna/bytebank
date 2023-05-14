package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto<T> {

    private String nome;
    private T produto;

}
