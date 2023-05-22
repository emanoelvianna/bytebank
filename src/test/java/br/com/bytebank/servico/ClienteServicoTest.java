package br.com.bytebank.servico;

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

    private Cliente cliente;

    @Before
    public void configuracao() {
        this.cliente = new Cliente("Emanoel Vianna",
                "01324596",
                LocalDate.of(1993, 01, 01),
                "Rua. Teste 1",
                "emanoel@gmail.com",
                "laranja123");
    }

    @Ignore
    @Test
    @DisplayName("criar método deve chamar o conjunto de métodos esperados")
    public void criar_metodo_deve_chamar_metodos_esperados() {
        Mockito.when(this.repository.save(Mockito.any())).thenReturn(null);
        this.servico.criar(this.cliente);

        Mockito.verify(this.repository).save(this.cliente);
    }


}
