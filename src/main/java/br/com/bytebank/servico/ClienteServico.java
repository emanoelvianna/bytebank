package br.com.bytebank.servico;

import br.com.bytebank.modelo.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClienteServico {

    private List<Cliente> clientes;

    public ClienteServico() {
        this.clientes = new ArrayList<>();
    }

    public Boolean addCliente(Cliente cliente) {
        return this.clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return this.clientes;
    }

    public Cliente getCliente(String documento) {

        for(Cliente cliente : clientes) {
            if(cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }

        return this.clientes.stream().filter(cliente -> cliente.getDocumento().equals(documento)).findFirst().orElse(null);
    }

    public List<Cliente> getClienteByDtNascimento() {
        List<Cliente> copia = new ArrayList<>(this.clientes);
        Collections.sort(copia);
        return copia;
    }

}
