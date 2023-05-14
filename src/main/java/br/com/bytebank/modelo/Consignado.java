package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Consignado {

    private BigDecimal margem;
    private BigDecimal valor;
    private String empregador;

}
