package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OPERADOR")
@Data
@SuperBuilder
@Generated
@AllArgsConstructor
public class Operador extends Funcionario implements Serializable {

    @Column(name = "N_CAIXA", length = 10, nullable = false)
    private Integer nCaixa;

    @Override
    public int compareTo(Funcionario funcionario) {
        if (this.getSalario().compareTo(funcionario.getSalario()) < 0) {
            return 1;
        } else if (this.getSalario().compareTo(funcionario.getSalario()) > 0) {
            return -1;
        }
        return 0;
    }
}
