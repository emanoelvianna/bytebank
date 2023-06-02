package br.com.bytebank.controller;

import br.com.bytebank.dto.GerenteDTO;
import br.com.bytebank.servico.GerenteServico;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/gerente")
public class GerenteController {

    private GerenteServico servico;

    @PostMapping
    public ResponseEntity<GerenteDTO> criar(@RequestBody GerenteDTO gerenteDTO) {
        return ResponseEntity.ok().body(this.servico.criar(gerenteDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deletar(@RequestHeader(name = "idGerente") Long idGerente) {
        this.servico.deletar(idGerente);
        return ResponseEntity.ok().body("Gerente deletado com sucesso");
    }

    @PutMapping
    public ResponseEntity<?> atualizarNome(@RequestBody GerenteDTO gerenteDTO) {
        return ResponseEntity.ok(this.servico.atualizar(gerenteDTO));
    }

}
