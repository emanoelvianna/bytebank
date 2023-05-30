package br.com.bytebank.dto;

import br.com.bytebank.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Cliente cliente;
    private BigDecimal saldo;
    private LocalDate dtCriacao;

}
