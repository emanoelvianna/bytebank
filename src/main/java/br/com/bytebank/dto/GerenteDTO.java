package br.com.bytebank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GerenteDTO {

    private String nome;
    private String documento;
    private BigDecimal salario;
    private String senha;

}
