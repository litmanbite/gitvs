package com.example.proj1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.Pedido;
import java.util.List;
import java.util.Optional;


public interface Pedidos extends JpaRepository<Pedido,Integer>{
    List<Pedido> findByCliente(Cliente cliente);

    Optional<Pedido> findByIdFetchItens(Integer id);
}
