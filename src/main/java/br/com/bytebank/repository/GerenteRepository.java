package br.com.bytebank.repository;

import br.com.bytebank.modelo.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    @Query("SELECT g FROM Gerente g WHERE g.documento = :documento")
    Gerente getGerenteByDocumento(@Param("documento") String documento);

    @Query("SELECT g FROM Gerente g ORDER BY g.salario DESC")
    List<Gerente> getAllGerentesBySalario();

}
