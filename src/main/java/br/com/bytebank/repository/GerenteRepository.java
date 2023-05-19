package br.com.bytebank.repository;

import br.com.bytebank.modelo.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    @Query("FROM Funcionario F WHERE F.documento = :documento")
    Gerente getGerenteByDocumento(@Param("documento") String documento);

    @Query("FROM Funcionario F ORDER BY F.salario DESC")
    List<Gerente> getAllGerentesBySalario();

}
