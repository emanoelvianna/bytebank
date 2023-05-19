package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CONSIGNADO")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Consignado {

    @Id
    @GeneratedValue
    @Column(name = "OID_CONSIGNADO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "MARGEM", length = 35, precision = 2, nullable = false)
    private BigDecimal margem;

    @Column(name = "VALOR", length = 35, precision = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "EMPREGADOR", length = 20, nullable = false)
    private String empregador;

    // TODO: DEFINIR RELAÇÃO COM O CLIENTE

}
