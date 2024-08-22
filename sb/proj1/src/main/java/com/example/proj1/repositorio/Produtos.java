package com.example.proj1.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj1.entities.Produto;

public interface Produtos extends JpaRepository<Produto,Integer> {


}
