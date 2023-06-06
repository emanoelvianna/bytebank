package br.com.bytebank.servico;

import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.exception.NotFoundException;
import br.com.bytebank.mapper.ClienteMapper;
import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServico {

    private ClienteRepository repository;
    private ClienteMapper mapper;

    public ClienteServico(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteDTO criar(ClienteDTO clienteDTO) {
        Cliente emanoel = new Cliente();
        emanoel.setNome(clienteDTO.getNome());
        Cliente cliente = this.mapper.fromDTO(clienteDTO);
        return this.mapper.toDTO(this.repository.save(cliente));
    }

    public ClienteDTO getClienteByDocumento(String documento) {
        Cliente cliente = this.repository.getClienteByDocumento(documento).orElseThrow(() -> {
            String mensagem = String.format("Cliente com documento: %s não foi encontrado.", documento);
            return new NotFoundException(mensagem);
        });
        return this.mapper.toDTO(cliente);
    }

    public List<ClienteDTO> findAllClientes() {
        List<Cliente> clientes = this.repository.findAll();
        return clientes.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public List<ClienteDTO> findByDtNascimento() {
        List<Cliente> clientes = this.repository.listarByDtNascimento();
        return clientes.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public void deletar(String documento) {
        Cliente cliente = this.repository.getClienteByDocumento(documento).orElseThrow(() -> {
            String mensagem = String.format("Cliente com documento: %s não foi encontrado.", documento);
            return new NotFoundException(mensagem);
        });
        this.repository.deleteById(cliente.getId());
    }
}
