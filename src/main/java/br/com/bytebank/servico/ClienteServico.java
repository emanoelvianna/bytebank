package br.com.bytebank.servico;

import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteServico {

    private ClienteRepository repository;

    public ClienteServico(ClienteRepository repository) {
        this.repository = repository;
        this.criar(null); // TODO: REMOVER
    }

    public Cliente criar(Cliente cliente) {
        Cliente outroCliente = Cliente
                .builder()
                .nome("Emanoel Vianna")
                .documento("870.491.550-04")
                .dtNascimento(LocalDate.of(1993, 01, 22))
                .email("emanoel@gmail.com")
                .endereco("69919-834")
                .senha("laranja123")
                .build();

        return this.repository.save(outroCliente);
    }

    public Cliente getCliente(String documento) {
        return this.repository.getClienteByDocumento(documento);
    }

    public List<Cliente> getAllClientes() {
        return this.repository.findAll();
    }

    public List<Cliente> listarByDtNascimento() {
        return this.repository.listarByDtNascimento();
    }

}
