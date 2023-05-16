package br.com.bytebank.repository;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FuncionarioRepository {

    // TODO: DEFINIR CONSULTA PARA BUSCAR FUNCIONARIO POR DOCUMENTO
    // TODO: LISTAR FUNCIONARIOS PELO SALARIO

    @Query("SELECT f FROM Funcionario f WHERE f.documento = :documento")
    Funcionario findByDocumento(@Param("documento") String documento);

    @Query("SELECT f FROM Funcionario f WHERE f.salario = :salario")
    List<Funcionario> findBySalario(@Param("salario") BigDecimal salario);


}
