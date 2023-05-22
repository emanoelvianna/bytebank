package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Generated
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Funcionario implements Comparable<Funcionario>, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "OID_FUNCIONARIO")
    private Long id;

    @Column(name = "NOME", length = 30, nullable = false)
    private String nome;

    @Column(name = "DOCUMENTO", length = 30, nullable = false)
    private String documento;

    @Column(name = "VLR_SALARIO", length = 38, precision = 2, nullable = false)
    private BigDecimal salario;

}
