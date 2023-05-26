package br.com.bytebank.dto;

import br.com.bytebank.modelo.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ContaDTO {

    private Cliente cliente;
    private BigDecimal saldo;
    private LocalDate dtCriacao;

}
