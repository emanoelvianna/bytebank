package br.com.bytebank.servico;

import br.com.bytebank.dto.GerenteDTO;
import br.com.bytebank.mapper.GerenteMapper;
import br.com.bytebank.modelo.Gerente;
import br.com.bytebank.repository.GerenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GerenteServico {

    private GerenteRepository repository;
    private GerenteMapper mapper;

    public GerenteServico(GerenteRepository repository, GerenteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GerenteDTO criar(GerenteDTO gerenteDTO) {
        log.info("Executando criação do gerente nome: {}", gerenteDTO.getNome());
        if(!gerenteDTO.getSenha().matches("^[a-zA-Z0-9]+$")) {
            log.error("GerenteDTO nome: {}, senha: {}", gerenteDTO.getNome(), gerenteDTO.getSenha());
            throw new RuntimeException("Gerente deve conter uma senha com letras e números"); // TODO: DEFINIR UMA EXCEÇÃO MAIS ESPESIFICA!
        }
        Gerente gerente = this.mapper.fromDTO(gerenteDTO);
        Gerente gerenteCriado = this.repository.save(gerente);
        log.info("Gerente {} foi criado com sucesso", gerenteCriado.getNome());
        return this.mapper.toDTO(gerenteCriado);
    }

    public GerenteDTO getGerenteByDocumento(String documento) {
        Gerente gerente = this.repository.getGerenteByDocumento(documento);
        return this.mapper.toDTO(gerente);
    }

    public List<GerenteDTO> getAllGerentesBySalario() {
        List<Gerente> gerentes = this.repository.getAllGerentesBySalario();
        return gerentes.stream().map(this.mapper::toDTO).collect(Collectors.toList());
    }

    public List<GerenteDTO> listar() {
        List<Gerente> gerentes = this.repository.findAll();
        return gerentes.stream().map(this.mapper::toDTO).collect(Collectors.toList());
    }

    public void deletar(Long idGerente) {
        this.repository.deleteById(idGerente);
    }

    public GerenteDTO atualizar(GerenteDTO gerenteDTO) {
        Gerente gerenteDB = this.repository.getGerenteByDocumento(gerenteDTO.getDocumento());
        Gerente gerente = this.mapper.fromDTO(gerenteDTO);
        gerente.setId(gerenteDB.getId());
        return this.mapper.toDTO(this.repository.save(gerente));
    }

}
