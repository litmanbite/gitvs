package com.example.proj1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.proj1.entities.Cliente;
import com.example.proj1.repositorio.Clientes;

@SpringBootApplication
public class Proj1Application {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes c){
		return args ->{
			Cliente cc = new Cliente(null,"le");
			c.save(cc);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Proj1Application.class, args);
	}
}
			
 