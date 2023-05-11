package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;
import br.com.bytebank.modelo.Gerente;
import br.com.bytebank.modelo.Operador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class FuncionarioServicoTest {

    private static String DOCUMENTO = "819.313.170-38";

    @InjectMocks
    private FuncionarioServico servico;
    private Funcionario gerente;
    private Funcionario operador;

    @Before
    public void configuracao() {
        this.gerente = new Gerente("Eduardo Silva",
                "819.313.170-38",
                new BigDecimal(8000),
                "laranja123");
        this.operador = new Operador("João Pedro",
                "077.711.910-29",
                new BigDecimal(5000), 1);
    }

    @DisplayName("listar metodo deve retornar lista vazia")
    @Test
    public void listar_metodo_deve_retornar_lista_vazia() {
        Assert.assertTrue(this.servico.listar().isEmpty());
    }

    @DisplayName("listar metodo deve retornar lista não vazia quando conter elementos")
    @Test
    public void listar_metodo_nao_deve_retornar_lista_vazia() {
        this.servico.adicionar(gerente);

        Assert.assertFalse(this.servico.listar().isEmpty());
    }

    @DisplayName("getFuncionario metodo deve retornar instancia de Funcionario")
    @Test
    public void getFuncionario_metodo_instancia() {
        this.servico.adicionar(gerente);
        this.servico.adicionar(operador);

        Assert.assertThat(this.servico.getFuncionario(DOCUMENTO), instanceOf(Funcionario.class));
    }

    @DisplayName("getFuncionario metodo deve retornar funcionario esperado")
    @Test
    public void getFuncionario_metodo_retorno() {
        this.servico.adicionar(gerente);
        this.servico.adicionar(operador);
        Funcionario retorno = this.servico.getFuncionario(DOCUMENTO);

        Assert.assertTrue(retorno.getDocumento().equals(DOCUMENTO));
    }

    @DisplayName("getFuncionario metodo não deve retornar funcionario quando não encontrado")
    @Test
    public void getFuncionario_metodo_nao_deve_retornar() {
        this.servico.adicionar(gerente);
        this.servico.adicionar(operador);
        Funcionario retorno = this.servico.getFuncionario("12345");

        Assert.assertNull(retorno);
    }

    @DisplayName("getFuncionariosBySalario metodo deve retornoar instancia de List")
    @Test
    public void getFuncionariosBySalario_metodo_instancia() {
        Assert.assertThat(this.servico.getFuncionariosBySalario(), instanceOf(List.class));
    }

    @DisplayName("getFuncionariosBySalario metodo deve retornar lista com ordem esperada")
    @Test
    public void getFuncionariosBySalario_metodo_ordem_esperada() {
        this.servico.adicionar(gerente);
        this.servico.adicionar(operador);
        List<Funcionario> retorno = this.servico.getFuncionariosBySalario();

        Funcionario retorno1 = retorno.get(0);
        Funcionario retorno2 = retorno.get(1);
        Assert.assertTrue(retorno1.getSalario().compareTo(retorno2.getSalario()) > -1);
    }

}
