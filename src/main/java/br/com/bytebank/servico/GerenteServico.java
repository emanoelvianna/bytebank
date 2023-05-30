package br.com.bytebank.servico;

import br.com.bytebank.modelo.Gerente;
import br.com.bytebank.repository.GerenteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GerenteServico {

    private GerenteRepository repository;

    public GerenteServico(GerenteRepository repository) {
        this.repository = repository;
        this.criar(null); // TODO: REMOVER
    }

    public void criar(Gerente gerente) {
        Gerente outroGerente = Gerente
                .builder()
                .nome("Marcos Silva")
                .documento("819.313.170-38")
                .salario(new BigDecimal(8.00))
                .senha("laranja123")
                .build();
        this.repository.save(outroGerente);
    }

    public Gerente getFuncionarioByDocumento(String documento) {
        return this.repository.getGerenteByDocumento(documento);
    }

    public List<Gerente> getAllFuncionariosBySalario() {
        return this.repository.getAllGerentesBySalario();
    }

    public List<Gerente> listar() {
        return this.repository.findAll();
    }

}
