package com.example.proj1.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.Produto;
import java.util.List;
import java.util.Optional;


public interface Produtos extends JpaRepository<Produto,Integer> {

    List<Produto> findByName(String nome);

    Produto findOneById(int id);

    boolean existsByName(String nome);

     @SuppressWarnings("null")
    Optional<Produto> findById(Integer id);

}
