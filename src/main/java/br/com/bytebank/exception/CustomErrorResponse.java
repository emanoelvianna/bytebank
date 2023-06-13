package br.com.bytebank.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomErrorResponse {

    private String mensagem;

}
