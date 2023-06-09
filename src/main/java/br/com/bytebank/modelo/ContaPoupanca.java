package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTA_POUPANCA")
@Data
@SuperBuilder
@Generated
@AllArgsConstructor
public class ContaPoupanca extends Conta implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "OID_CPOUPANCA")
    private Long id;

}
