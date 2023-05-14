package br.com.bytebank.controller;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.servico.ContaServico;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/conta")
public class ContaController {

    private ContaServico servico;

    @PostMapping
    public Conta criarConta() {
        return this.servico.criar();
    }

    @GetMapping
    public Conta getContaByDocumento() {
        return null;
    }

}
