package br.com.bytebank.mapper;

import br.com.bytebank.dto.GerenteDTO;
import br.com.bytebank.modelo.Gerente;
import org.mapstruct.Mapper;

@Mapper
public interface GerenteMapper {

    Gerente fromDTO(GerenteDTO gerenteDTO);

    GerenteDTO toDTO(Gerente gerente);

}
