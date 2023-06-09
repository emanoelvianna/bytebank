package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CONSIGNADO")
@Data
@Builder
@AllArgsConstructor
public class Consignado implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

}
