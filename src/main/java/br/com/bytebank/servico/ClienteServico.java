package br.com.bytebank.servico;

import br.com.bytebank.modelo.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteServico {

    private List<Cliente> clientes;

    public ClienteServico() {
        this.clientes = new ArrayList<>();
    }

    public Boolean adicionar(Cliente cliente) {
        return this.clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return this.clientes;
    }

    public List<Cliente> listarByDtNascimento() {
        List<Cliente> copia = new ArrayList<>(this.clientes);
        Collections.sort(copia);
        return copia;
    }

    public Cliente getCliente(String documento) {
        return this.clientes
                .stream()
                .filter(cliente -> cliente.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }

}
