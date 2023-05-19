package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "CREDITO")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Credito {

    @Id
    @GeneratedValue
    @Column(name = "CREDITO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "MARGEM", length = 35, precision = 2, nullable = false)
    private BigDecimal margem;

    @Column(name = "VLR_CRED", length = 3)
    private BigDecimal valor;

}
