package br.com.bytebank.servico;

import br.com.bytebank.modelo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    private FuncionarioServico funcionarioServico;
    private Autenticavel gerente;
    private Conta conta;
    private Cliente cliente;

    @Before
    public void configuracao() {
        this.gerente = new Gerente("Marcos Silva", "01324596", new BigDecimal(5000), "laranja123");
        this.cliente = new Cliente("Emanoel Vianna",
                "01324596",
                LocalDate.of(1993, 01, 01),
                "Rua. Teste 1",
                "emanoel@gmail",
                "laranja123");
        this.conta = new ContaCorrente(this.cliente);
    }

    @DisplayName("Depositar metodo deve retornar instancia BigDecimal")
    @Test
    public void depositar_metodo_deve_retornar_instancia_BigDecimal() {
        Assert.assertThat(this.servico.depositar(this.gerente, this.conta, new BigDecimal(100)), instanceOf(BigDecimal.class));
    }

    @DisplayName("Depositar metodo deve despostiar valor na conta quando chamado")
    @Test
    public void depositar_metodo_deve_despostiar_valor_na_conta_quando_metodo_add_chamado() {
        this.servico.depositar(this.gerente, this.conta, new BigDecimal(100));

        Assert.assertTrue(this.conta.getSaldo().equals(new BigDecimal(100)));
    }

}
