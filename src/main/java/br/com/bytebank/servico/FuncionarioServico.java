package br.com.bytebank.servico;

import br.com.bytebank.modelo.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioServico {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
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

}
