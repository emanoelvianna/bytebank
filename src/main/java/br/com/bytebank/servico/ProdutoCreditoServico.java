package br.com.bytebank.servico;

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
        Cliente cliente = this.clienteRepository.getClienteByDocumento(documento);
        credito.setCliente(cliente);
        this.creditoRepository.save(credito);
        return credito;
    }

}
