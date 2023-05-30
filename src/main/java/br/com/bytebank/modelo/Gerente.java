package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "GERENTE")
@Data
@SuperBuilder
@Generated
@AllArgsConstructor
public class Gerente extends Funcionario implements Autenticavel, Serializable {

    @Column(name = "SENHA", length = 20, nullable = false)
    private String senha;

    @Override
    public Boolean autentica(String senha) {
        return this.senha.equals(senha);
    }

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
