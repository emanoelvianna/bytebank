package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Finciamento {

    private BigDecimal margem;
    private BigDecimal valor;

}
