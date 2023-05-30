package br.com.bytebank.repository;

import br.com.bytebank.modelo.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Query("FROM Conta C WHERE C.cliente.documento = :documento")
    ContaCorrente getContaByDocumento(@Param("documento") String documento);

}
