package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
public class Cliente implements Autenticavel, Comparable<Cliente> {

    @Id
    @GeneratedValue
    @Column(name = "OID_CLIENTE")
    private Long id;

    @Column(name = "NOME", length = 20, nullable = false)
    private String nome;

    @Column(name = "DOCUMENTO", length = 20, nullable = false)
    private String documento;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dtNascimento;

    @Column(name = "ENDERECEO", length = 30, nullable = true)
    private String endereco;

    @Column(name = "EMAIL", length = 20, nullable = false)
    private String email;

    @Column(name = "SENHA", length = 20, nullable = false)
    private String senha;


    @Override
    public Boolean autentica(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public int compareTo(Cliente cliente) {
        if (this.dtNascimento.isBefore(cliente.getDtNascimento())) {
            return -1;
        }
        if (this.dtNascimento.isAfter(cliente.getDtNascimento())) {
            return 1;
        }
        return 0;
    }
}
