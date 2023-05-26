package br.com.bytebank.controller;

import br.com.bytebank.dto.ContaDTO;
import br.com.bytebank.servico.ContaCorrenteServico;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

    private ContaCorrenteServico servico;

    @PostMapping
    public ResponseEntity<ContaDTO> criarConta(@RequestHeader(name = "documento", defaultValue = "") String documento, @RequestBody ContaDTO contaDTO) {
        return ResponseEntity.ok().body(this.servico.criar(documento, contaDTO));
    }

    @GetMapping
    public ResponseEntity<ContaDTO> getContaByDocumento(@RequestHeader(name = "documento", defaultValue = "") String documento) {
        return ResponseEntity.ok().body(this.servico.getContaByDocumento(documento));
    }

}
