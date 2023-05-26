package br.com.bytebank.servico;

import br.com.bytebank.dto.ContaDTO;
import br.com.bytebank.mapper.ContaCorrenteMapper;
import br.com.bytebank.modelo.Autenticavel;
import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;
import br.com.bytebank.repository.ClienteRepository;
import br.com.bytebank.repository.ContaCorrenteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaCorrenteServico {

    private ContaCorrenteRepository contaCorrenteRepository;
    private ClienteRepository clienteRepository;
    private ContaCorrenteMapper mapper;

    public ContaCorrenteServico(ContaCorrenteRepository contaCorrenteRepository, ClienteRepository clienteRepository, ContaCorrenteMapper mapper) {
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    public ContaDTO criar(String documento, ContaDTO contaDTO) {
        Cliente cliente = this.clienteRepository.getClienteByDocumento(documento);
        ContaCorrente contaCorrente = this.mapper.fromDTO(contaDTO);
        contaCorrente.setCliente(cliente);

        return this.mapper.toDTO(this.contaCorrenteRepository.save(contaCorrente));
    }

    public ContaDTO getContaByDocumento(String documento) {
        return this.mapper.toDTO(this.contaCorrenteRepository.getContaByDocumento(documento));
    }

    public BigDecimal depositar(Autenticavel autenticavel, Conta conta, BigDecimal valor) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().add(valor);
            conta.setSaldo(result);
            return result;
        }
        return null; // TODO: DEVERIAMOS JOGAR UMA EXCEÇÃO!!!
    }

    public BigDecimal sacar(Autenticavel autenticavel, Conta conta, BigDecimal value) {
        if (this.login(autenticavel)) {
            BigDecimal result = conta.getSaldo().subtract(value);
            conta.setSaldo(result);
            return result;
        }
        return null; // TODO: DEVERIAMOS JOGAR UMA EXCEÇÃO!!!
    }

    private Boolean login(Autenticavel autenticavel) {
        String senha = new String("laranja123"); // TODO: SENHA DE ENTRADA
        return autenticavel.autentica(senha);
    }
}
