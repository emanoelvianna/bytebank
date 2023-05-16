package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="FUNCIONARIO")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Funcionario implements Comparable<Funcionario> {

    @Id
    @GeneratedValue
    @Column(name = "ID_FUNCIONARIO")
    private long id;

    private String nome;

    private String documento;

    private BigDecimal salario;

}
