package br.com.bytebank.controller;

import br.com.bytebank.IntegrationTest;
import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.repository.ClienteRepository;
import br.com.bytebank.servico.ClienteServico;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@IntegrationTest
@RunWith(SpringRunner.class)
public class ClienteControllerTest {

    public static final String DOCUMENTO = "090.772.710-74";
    @Autowired
    private TestRestTemplate rest;
    @Autowired
    private ClienteServico servico;
    @Autowired
    private ClienteRepository repository;

    private ClienteDTO clienteDTO;

    @Before
    public void config() {
        this.clienteDTO = ClienteDTO
                .builder()
                .nome("Eduardo Silva")
                .documento(DOCUMENTO)
                .dtNascimento(LocalDate.of(1993, 01, 01))
                .endereco("69086-272")
                .email("eduardo@gmail.com")
                .senha("laranja123")
                .build();
    }

    @Test
    @DisplayName("criar método deve inserir um registro de cliente no banco de dados")
    public void criarMetodoDeveInserirCliente() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ClienteDTO> request = new HttpEntity<>(this.clienteDTO, headers);
        ResponseEntity<ClienteDTO> retorno = this.rest.exchange("/cliente", HttpMethod.POST, request, ClienteDTO.class);

        Assertions.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(retorno.getBody().getDocumento(), DOCUMENTO);
        Assertions.assertFalse(this.repository.findAll().isEmpty());
    }

    @Test
    @DisplayName("deletar método deve deletar um cliente quando chamando com um documento valido")
    public void deletarMetodoDeveDeletarCliente() {
        String documento = new String("476.720.960-95");
        ClienteDTO dto = ClienteDTO
                .builder()
                .nome("Eduardo Silva")
                .documento(documento)
                .dtNascimento(LocalDate.of(1993, 01, 01))
                .endereco("69086-272")
                .email("eduardo@gmail.com")
                .senha("laranja123")
                .build();
        this.servico.criar(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("documento", documento);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Void> retorno = this.rest.exchange("/cliente", HttpMethod.DELETE, request, Void.class);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

    @Test
    @DisplayName("getClienteByDocumento metodo deve retornar um cliente")
    public void getClienteByDocumentoMetodoDeveRetornarCliente() {
        String documento = new String("476.720.961-95");
        ClienteDTO dto = ClienteDTO
                .builder()
                .nome("Eduardo Silva")
                .documento(documento)
                .dtNascimento(LocalDate.of(1993, 01, 01))
                .endereco("69086-272")
                .email("eduardo@gmail.com")
                .senha("laranja123")
                .build();
        this.servico.criar(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("documento", documento);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<ClienteDTO> retorno = this.rest.exchange("/cliente/documento", HttpMethod.GET, request, ClienteDTO.class);

        Assertions.assertEquals(retorno.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(retorno.getBody().getDocumento(), documento);
    }

}
