package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CONSIGNADO")
@Data
@AllArgsConstructor
public class Consignado {

    @Id
    @GeneratedValue
    @Column(name = "OID_CONSIGNADO")
    private Long id;

    @Column(name = "MARGEM", length = 35, precision = 2, nullable = false)
    private BigDecimal margem;

    @Column(name = "VALOR", length = 35, precision = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "EMPREGADOR", length = 20, nullable = false)
    private String empregador;

    // TODO: DEFINIR RELAÇÃO COM O CLIENTE

}
