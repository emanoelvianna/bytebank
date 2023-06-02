package br.com.bytebank.controller;

import br.com.bytebank.IntegrationTest;
import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.repository.ClienteRepository;
import br.com.bytebank.servico.ClienteServico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.time.LocalDate;

@IntegrationTest
@RunWith(SpringRunner.class)
public class ClienteControllerTest {

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
                .documento("090.772.710-74")
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
        this.rest.exchange("/cliente", HttpMethod.POST, request, ClienteDTO.class);

        // TODO: ADICIONAR VERIFICAÇÕES
        this.repository.getClienteByDocumento("090.772.710-74");
    }

}
