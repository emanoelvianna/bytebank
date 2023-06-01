package br.com.bytebank.servico;

import br.com.bytebank.dto.GerenteDTO;
import br.com.bytebank.mapper.GerenteMapper;
import br.com.bytebank.modelo.Funcionario;
import br.com.bytebank.modelo.Gerente;
import br.com.bytebank.repository.GerenteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class GerenteServicoTest {

    private static String DOCUMENTO = "819.313.170-38";

    @InjectMocks
    private GerenteServico servico;
    @Mock
    private GerenteRepository repository;
    @Mock
    private GerenteMapper mapper;
    private Gerente gerente;
    private GerenteDTO gerenteDTO;

    @Before
    public void configuracao() {
        this.gerente = Gerente
                .builder()
                .nome("Marcos Silva")
                .documento(DOCUMENTO)
                .salario(new BigDecimal(8000))
                .senha("laranja123")
                .build();

        this.gerenteDTO = GerenteDTO.builder().build();

        when(this.mapper.toDTO(Mockito.any())).thenReturn(this.gerenteDTO);
    }

    @Test
    @DisplayName("listar metodo deve retornar lista vazia")
    public void listar_metodo_deve_retornar_lista_vazia() {
        Assert.assertTrue(this.servico.listar().isEmpty());
    }

    @Test
    @DisplayName("listar metodo deve retornar lista não vazia quando conter elementos")
    public void listar_metodo_nao_deve_retornar_lista_vazia() {
        List<Gerente> gerentes = Arrays.asList(this.gerente);
        when(this.repository.findAll()).thenReturn(gerentes);

        Assert.assertFalse(this.servico.listar().isEmpty());
    }

    @Test
    @DisplayName("getGerenteByDocumento metodo deve retornar instancia de Funcionario")
    public void getGerenteByDocumento_metodo_instancia() {
        when(this.repository.getGerenteByDocumento(DOCUMENTO)).thenReturn(this.gerente);

        Assert.assertThat(this.servico.getGerenteByDocumento(DOCUMENTO), instanceOf(GerenteDTO.class));
    }

    @Test
    @DisplayName("getGerenteByDocumento metodo deve retornar funcionario esperado")
    public void getGerenteByDocumento_metodo_retorno() {
        when(this.repository.getGerenteByDocumento(Mockito.anyString())).thenReturn(this.gerente);

        GerenteDTO retorno = this.servico.getGerenteByDocumento(DOCUMENTO);

        Assert.assertTrue(retorno.getDocumento().equals(DOCUMENTO));
    }

    @Test
    @DisplayName("getGerenteByDocumento metodo não deve retornar funcionario quando não encontrado")
    public void getGerenteByDocumento_metodo_nao_deve_retornar() {
        this.servico.criar(gerenteDTO);
        GerenteDTO retorno = this.servico.getGerenteByDocumento("12345");

        Assert.assertNull(retorno);
    }

    @Test
    @DisplayName("getAllGerentesBySalario metodo deve retornoar instancia de List")
    public void getAllGerentesBySalario_metodo_instancia() {
        List<Gerente> gerentes = Arrays.asList(this.gerente);
        when(this.repository.getAllGerentesBySalario()).thenReturn(gerentes);

        Assert.assertThat(this.servico.getAllGerentesBySalario(), instanceOf(List.class));
    }

    @Test
    @DisplayName("getFuncionariosBySalario metodo deve retornar lista com ordem esperada")
    public void getAllFuncionariosBySalario_metodo_ordem_esperada() {
        Gerente outroGerente = Gerente
                .builder()
                .nome("Edurado Silva")
                .documento("819.313.170-38")
                .salario(new BigDecimal(5000))
                .senha("laranja123")
                .build();
        List<Gerente> gerentes = Arrays.asList(this.gerente, outroGerente);
        when(this.repository.getAllGerentesBySalario()).thenReturn(gerentes);

        List<GerenteDTO> retorno = this.servico.getAllGerentesBySalario();

        GerenteDTO retorno1 = retorno.get(0);
        GerenteDTO retorno2 = retorno.get(1);
        Assert.assertTrue(retorno1.getSalario().compareTo(retorno2.getSalario()) > -1);
    }

}
