package br.com.bytebank.repository;

import br.com.bytebank.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("FROM Cliente C WHERE C.documento = :documento")
    Optional<Cliente> getClienteByDocumento(@Param("documento") String documento);

    @Query("FROM Cliente C ORDER BY C.dtNascimento DESC")
    List<Cliente> listarByDtNascimento();

}
