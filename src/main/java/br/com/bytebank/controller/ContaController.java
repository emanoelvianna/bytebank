package br.com.bytebank.controller;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.servico.ContaServico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class ContaController {

    private ContaServico servico;

    public ContaController(ContaServico servico) {
        this.servico = servico;
    }

    @PostMapping
    public Conta criarConta() {
        return this.servico.criar();
    }

    @GetMapping
    public Conta getConta() {
        return this.servico.getConta();
    }

}
