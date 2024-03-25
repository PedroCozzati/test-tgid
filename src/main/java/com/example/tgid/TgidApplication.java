package com.example.tgid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tgid.sistema.Sistema;

@SpringBootApplication
public class TgidApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgidApplication.class, args);
		String cpf = "435.157.148-98";
        System.out.println("CPF válido: " + Sistema.validarDocumento(cpf));
	}

}
