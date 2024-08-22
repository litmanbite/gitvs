package com.example.proj1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj1.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido,Integer>{
     
}
