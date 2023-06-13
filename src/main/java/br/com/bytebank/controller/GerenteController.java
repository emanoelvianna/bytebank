package br.com.bytebank.controller;

import br.com.bytebank.dto.GerenteDTO;
import br.com.bytebank.exception.BusinessException;
import br.com.bytebank.exception.CustomErrorResponse;
import br.com.bytebank.exception.NotFoundException;
import br.com.bytebank.servico.GerenteServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<Object> businessException(BusinessException ex) {
        CustomErrorResponse retorno = CustomErrorResponse.builder().mensagem(ex.getMessage()).build();
        return new ResponseEntity<Object>(retorno, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
