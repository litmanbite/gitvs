package com.example.proj1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.Pedido;
import java.util.List;
import java.util.Optional;


public interface Pedidos extends JpaRepository<Pedido,Integer>{
    List<Pedido> findByCliente(Cliente cliente);

    @Query(" select p from Pedido p left join fetch p.itens where p.id = :id ")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
