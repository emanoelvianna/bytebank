package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioServico {

    private List<Funcionario> funcionarios;

    public FuncionarioServico() {
        this.funcionarios = new ArrayList<>();
    }

    public boolean addFuncionario(Funcionario funcionario) {
        return this.funcionarios.add(funcionario);
    }

    public List<Funcionario> listar() {
        return this.funcionarios;
    }

    public List<Funcionario> getFuncionarios(String documento) {

        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getDocumento().equals(documento)) {
                return funcionarios;
            }
        }

        return (List<Funcionario>) this.funcionarios.stream().filter(funcionario -> funcionario.getDocumento().equals(documento)).findFirst().orElse(null);
    }

    public List<Funcionario> getFuncionarioBySalario() {
        List<Funcionario> copia = new ArrayList<>(this.funcionarios);
        Collections.sort(copia);
        return copia;
    }
}
