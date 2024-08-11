package com.example.proj1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.proj1.entities.Cliente;
import com.example.proj1.repositorio.Clientes;

@SpringBootApplication
public class Proj1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Proj1Application.class, args);
	}
	@Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setName("Litman");
			clientes.salvar(cliente);

			Cliente cliente1 = new Cliente();
			cliente1.setName("Leandra");
			clientes.salvar(cliente1);

			List<Cliente> listinha = clientes.obterTodos();
			for (Cliente e : listinha) {
				System.out.println(e.toString());
			}
			listinha.clear();
			/*for (Cliente e : listinha){
				if (e.getId()<2)
					clientes.deletar(e.getId());
			}*/

			//Cliente clientin = new Cliente();

			listinha = clientes.obterTodos();
			for (Cliente e : listinha) {
				e.setName(e.getName()+" sobrenome");
				clientes.atualizar(e);
				System.out.println(e.toString());
			}
			listinha.clear();

			listinha = clientes.buscaNome("t");

			System.out.println(listinha.toString());
			
		};
    }
}
