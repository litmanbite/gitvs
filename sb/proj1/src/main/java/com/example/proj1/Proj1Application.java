package com.example.proj1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.Pedido;
import com.example.proj1.repositorio.Clientes;
import com.example.proj1.repositorio.Pedidos;

@SpringBootApplication
public class Proj1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Proj1Application.class, args);
	}
	@Bean
    public CommandLineRunner init(@Autowired Clientes clientes,@Autowired Pedidos pedidos){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setName("Litman");
			clientes.save(cliente);

			Cliente cliente1 = new Cliente();
			cliente1.setName("Le");
			clientes.save(cliente1);

			List<Cliente> listinha = clientes.findAll();
			for (Cliente e : listinha) {
				System.out.println(e.toString());
			}
			listinha.clear();
			/*for (Cliente e : listinha){
				if (e.getId()<2)
					clientes.deletar(e.getId());
			}*/

			//Cliente clientin = new Cliente();

			listinha = clientes.findAll();
			for (Cliente e : listinha) {
				if (clientes.existsByName("Litman")){
				e.setName(e.getName()+" sobrenome");
				clientes.save(e);
				System.out.println(e.toString());}
			}
			listinha.clear();
			Pedido p = new Pedido();
			p.setCliente(cliente1);
			p.setData(LocalDate.now());
			pedidos.save(p);
			Set<Pedido> s = new HashSet<>();
			s.add(p);
			cliente1.setPedidos(s);
			System.out.println(cliente1.getPedidos().toString()); 
		};}}
			
 