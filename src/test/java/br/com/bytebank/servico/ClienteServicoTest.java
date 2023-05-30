package br.com.bytebank.servico;

import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServicoTest {

    @InjectMocks
    private ClienteServico servico;
    @Mock
    private ClienteRepository repository;

    private ClienteDTO clienteDTO;
    private Cliente cliente;

    @Before
    public void configuracao() {
        this.clienteDTO = ClienteDTO.builder()
                .nome("Emanoel Vianna")
                .documento("01324596")
                .dtNascimento(LocalDate.of(1993, 01, 01))
                .endereco("Rua. Teste 1")
                .email("emanoel@gmail.com")
                .senha("laranja123")
                .build();
    }

    @Ignore
    @Test
    @DisplayName("criar método deve chamar o conjunto de métodos esperados")
    public void criar_metodo_deve_chamar_metodos_esperados() {
        Mockito.when(this.repository.save(Mockito.any())).thenReturn(null);
        this.servico.criar(this.clienteDTO);

        Mockito.verify(this.repository).save(this.cliente);
    }

}
