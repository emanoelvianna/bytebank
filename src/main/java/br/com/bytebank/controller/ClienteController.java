package br.com.bytebank.controller;


import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.servico.ClienteServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteServico servico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok().body(this.servico.criar(clienteDTO));
    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAllClientes() {
        return ResponseEntity.ok(this.servico.findAllClientes());
    }

    @GetMapping("/data-nascimento")
    public ResponseEntity<List<ClienteDTO>> findByDtNascimento() {
        return ResponseEntity.ok(this.servico.findByDtNascimento());
    }

    @GetMapping("/documento")
    public ResponseEntity<ClienteDTO> getClienteByDocumento(@RequestHeader(name = "documento") String documento) {
        return ResponseEntity.ok().body(this.servico.getClienteByDocumento(documento));
    }

}
