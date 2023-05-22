package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CREDITO")
@Data
@Builder
@AllArgsConstructor
public class Credito implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "OID_CREDITO")
    private Long id;

    @Column(name = "MARGEM", length = 38, precision = 2, nullable = false)
    private BigDecimal margem;

    @Column(name = "VLR_CREDITO", length = 38, precision = 2, nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

}
