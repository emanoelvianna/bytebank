package br.com.bytebank.mapper;

import br.com.bytebank.dto.ContaDTO;
import br.com.bytebank.modelo.ContaCorrente;
import org.mapstruct.Mapper;

@Mapper
public interface ContaCorrenteMapper {

    ContaCorrente fromDTO(ContaDTO contaDTO);

    ContaDTO toDTO(ContaCorrente contaCorrente);

}
