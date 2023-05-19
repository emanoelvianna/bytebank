package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Credito {

    private BigDecimal margem;
    private BigDecimal valor;

    // TODO: DEFINIR RELAÇÃO COM O CLIENTE

}
