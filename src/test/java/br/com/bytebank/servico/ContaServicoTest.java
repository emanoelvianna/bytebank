package br.com.bytebank.servico;

import br.com.bytebank.modelo.*;
import br.com.bytebank.repository.ContaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContaServicoTest {

    @InjectMocks
    private ContaServico servico;
    @Mock
    private ContaRepository repository;
    private Autenticavel gerente;
    private Conta conta;
    private Cliente cliente;

    @Before
    public void configuracao() {
        this.gerente = Gerente
                .builder()
                .nome("Marcos Silva")
                .documento("01324596")
                .salario(new BigDecimal(5000))
                .senha("laranja123")
                .build();

        this.cliente = new Cliente("Emanoel Vianna",
                "01324596",
                LocalDate.of(1993, 01, 01),
                "Rua. Teste 1",
                "emanoel@gmail",
                "laranja123");
        this.conta = ContaCorrente
                .builder()
                .id(1L)
                .cliente(this.cliente)
                .dtCriacao(LocalDate.now())
                .saldo(new BigDecimal(100))
                .build();
    }

    @Test
    public void getConta_metodo_deve_retornar_conta_quando_cliente_existir() {
        when(this.repository.getContaByDocumento(Mockito.anyString())).thenReturn(this.conta);

        Assert.assertThat(this.servico.getDocumento("01324596"), instanceOf(Conta.class));
    }

    @Test
    public void getConta_metodo_deve_chamar_getContaByDocumento_metodo() {
        ContaCorrente cConta = Mockito.mock(ContaCorrente.class);
        when(this.repository.getContaByDocumento(Mockito.anyString())).thenReturn(cConta);
        this.servico.getDocumento("01324596");

        Mockito.verify(this.repository).getContaByDocumento(Mockito.anyString());
    }

    @DisplayName("depositar metodo deve retornar instancia BigDecimal")
    @Test
    public void depositar_metodo_deve_retornar_instancia_BigDecimal() {
        Assert.assertThat(this.servico.depositar(this.gerente, this.conta, new BigDecimal(100)), instanceOf(BigDecimal.class));
    }

    @DisplayName("depositar metodo deve despositar valor na conta quando chamado")
    @Test
    public void depositar_metodo_deve_despositar_valor_quando_chamado() {
        this.conta = ContaCorrente
                .builder()
                .id(1L)
                .cliente(this.cliente)
                .dtCriacao(LocalDate.now())
                .saldo(BigDecimal.ZERO)
                .build();
        this.servico.depositar(this.gerente, this.conta, new BigDecimal(100));

        Assert.assertTrue(this.conta.getSaldo().equals(new BigDecimal(100)));
    }

    @DisplayName("sacar metodo deve retornar instancia BigDecimal")
    @Test
    public void sacar_metodo_deve_retornar_instancia_BigDecimal() {
        Assert.assertThat(this.servico.sacar(this.gerente, this.conta, new BigDecimal(100)), instanceOf(BigDecimal.class));
    }

    @DisplayName("scar metodo deve despositar valor na conta quando chamado")
    @Test
    public void sacar_metodo_deve_sacar_valor_quando_chamado() {
        this.conta = ContaCorrente
                .builder()
                .id(1L)
                .cliente(this.cliente)
                .dtCriacao(LocalDate.now())
                .saldo(BigDecimal.ZERO)
                .build();
        this.servico.depositar(this.gerente, this.conta, new BigDecimal(100));
        this.servico.sacar(this.gerente, this.conta, new BigDecimal(50));

        Assert.assertTrue(this.conta.getSaldo().equals(new BigDecimal(50)));
    }
}
