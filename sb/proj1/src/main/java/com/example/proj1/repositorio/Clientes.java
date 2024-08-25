package com.example.proj1.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proj1.entities.Cliente;

//  QUERY METHODS   

@Repository
public interface Clientes extends JpaRepository<Cliente,Integer>{

    List<Cliente> findByName(String name);

    Cliente findOneById(Integer id);

    boolean existsByName(String nome);

    @SuppressWarnings("null")
    @EntityGraph(attributePaths = {"pedidos"})
    Optional<Cliente> findById(Integer id);
}
