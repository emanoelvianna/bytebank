package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Conta implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "OID_CONTA")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_CLIENTE", referencedColumnName = "OID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "VLR_SALDO", length = 35, precision = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDate dtCriacao;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
        this.dtCriacao = LocalDate.now();
    }
}
