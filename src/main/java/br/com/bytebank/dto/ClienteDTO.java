package br.com.bytebank.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClienteDTO {

    private String nome;
    private String documento;
    private LocalDate dtNascimento;
    private String endereco;
    private String email;
    private String senha;

}
