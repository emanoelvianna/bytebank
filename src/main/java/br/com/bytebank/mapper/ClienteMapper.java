package br.com.bytebank.mapper;

import br.com.bytebank.dto.ClienteDTO;
import br.com.bytebank.modelo.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

    Cliente fromDTO(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);

}
