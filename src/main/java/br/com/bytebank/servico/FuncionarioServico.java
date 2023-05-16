package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;
import br.com.bytebank.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FuncionarioServico {

    private List<Funcionario> funcionarios;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServico() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionar(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario findByDocumento(String documento) {
        return funcionarioRepository.findByDocumento(documento);
    }


    public Funcionario getFuncionario(String documento) {
        return this.funcionarios
                .stream()
                .filter(funcionario -> funcionario.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }

    public List<Funcionario> getFuncionariosBySalario() {
        List<Funcionario> copia = new ArrayList<>(this.funcionarios);
        Collections.sort(copia);
        return copia;
    }

    public List<Funcionario> listar() {
        return this.funcionarios;
    }

}
