package com.example.proj1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj1.entities.ItemPedido;

public interface Itens extends JpaRepository<ItemPedido,Integer> {

}
