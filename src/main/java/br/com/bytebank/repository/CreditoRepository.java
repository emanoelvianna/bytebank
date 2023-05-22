package br.com.bytebank.repository;

import br.com.bytebank.modelo.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoRepository extends JpaRepository<Credito, Long> {

}
