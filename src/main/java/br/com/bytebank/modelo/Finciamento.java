package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FINANCIAMENTO")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Finciamento {

    @Id
    @GeneratedValue
    @Column(name = "OID_FINANC")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "MARGEM", precision = 2, nullable = false)
    private BigDecimal margem;

    @Column(name = "VLR_FINANC", precision = 2, nullable = false)
    private BigDecimal valor;

}
