package br.com.bytebank;


import br.com.bytebank.modelo.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Principal {

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
    }

    @Bean
    public CommandLineRunner helloWord() {
        return args -> System.out.println("Olá mundo");
    }

}