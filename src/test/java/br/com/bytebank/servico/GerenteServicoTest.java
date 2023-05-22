package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;
import br.com.bytebank.modelo.Gerente;
import br.com.bytebank.repository.GerenteRepository;
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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GerenteServicoTest {

    private static String DOCUMENTO = "819.313.170-38";

    @InjectMocks
    private GerenteServico servico;
    @Mock
    private GerenteRepository repository;

    private Gerente marcos;
    private Gerente eduardo;

    @Before
    public void configuracao() {
        this.marcos = Gerente
                .builder()
                .nome("Marcos Silva")
                .documento("819.313.170-38")
                .salario(new BigDecimal(8000))
                .senha("laranja123")
                .build();

        this.eduardo = Gerente
                .builder()
                .nome("Edurado Silva")
                .documento("819.313.170-38")
                .salario(new BigDecimal(5000))
                .senha("laranja123")
                .build();
    }

    @DisplayName("listar metodo deve retornar lista vazia")
    @Test
    public void listar_metodo_deve_retornar_lista_vazia() {
        Assert.assertTrue(this.servico.listar().isEmpty());
    }

    @DisplayName("listar metodo deve retornar lista não vazia quando conter elementos")
    @Test
    public void listar_metodo_nao_deve_retornar_lista_vazia() {
        List<Gerente> gerentes = Arrays.asList(this.marcos);
        when(this.repository.findAll()).thenReturn(gerentes);

        Assert.assertFalse(this.servico.listar().isEmpty());
    }

    @DisplayName("getFuncionario metodo deve retornar instancia de Funcionario")
    @Test
    public void getFuncionario_metodo_instancia() {
        when(this.repository.getGerenteByDocumento(Mockito.anyString())).thenReturn(this.marcos);

        Assert.assertThat(this.servico.getFuncionarioByDocumento(DOCUMENTO), instanceOf(Funcionario.class));
    }

    @DisplayName("getFuncionario metodo deve retornar funcionario esperado")
    @Test
    public void getFuncionario_metodo_retorno() {
        when(this.repository.getGerenteByDocumento(Mockito.anyString())).thenReturn(this.marcos);

        Funcionario retorno = this.servico.getFuncionarioByDocumento(DOCUMENTO);

        Assert.assertTrue(retorno.getDocumento().equals(DOCUMENTO));
    }

    @DisplayName("getFuncionario metodo não deve retornar funcionario quando não encontrado")
    @Test
    public void getFuncionario_metodo_nao_deve_retornar() {
        this.servico.criar(marcos);
        Gerente retorno = this.servico.getFuncionarioByDocumento("12345");

        Assert.assertNull(retorno);
    }

    @DisplayName("getFuncionariosBySalario metodo deve retornoar instancia de List")
    @Test
    public void getAllFuncionariosBySalario_metodo_instancia() {
        List<Gerente> gerentes = Arrays.asList(this.marcos, this.eduardo);
        when(this.repository.getAllGerentesBySalario()).thenReturn(gerentes);

        Assert.assertThat(this.servico.getAllFuncionariosBySalario(), instanceOf(List.class));
    }

    @DisplayName("getFuncionariosBySalario metodo deve retornar lista com ordem esperada")
    @Test
    public void getAllFuncionariosBySalario_metodo_ordem_esperada() {
        List<Gerente> gerentes = Arrays.asList(this.marcos, this.eduardo);
        when(this.repository.getAllGerentesBySalario()).thenReturn(gerentes);

        List<Gerente> retorno = this.servico.getAllFuncionariosBySalario();

        Funcionario retorno1 = retorno.get(0);
        Funcionario retorno2 = retorno.get(1);
        Assert.assertTrue(retorno1.getSalario().compareTo(retorno2.getSalario()) > -1);
    }

}
