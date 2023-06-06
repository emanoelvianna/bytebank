package br.com.bytebank.servico;

import br.com.bytebank.exception.NotFoundException;
import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.Credito;
import br.com.bytebank.repository.ClienteRepository;
import br.com.bytebank.repository.CreditoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoCreditoServico {

    private ClienteRepository clienteRepository;
    private CreditoRepository creditoRepository;

    public Credito addProduto(String documento, Credito credito) {
        Cliente cliente = this.clienteRepository.getClienteByDocumento(documento).orElseThrow(() -> {
            String mensagem = String.format("Cliente com documento: %s não foi encontrado.");
            return new NotFoundException(mensagem);
        });
        credito.setCliente(cliente);
        this.creditoRepository.save(credito);
        return credito;
    }

}
