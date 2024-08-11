package com.example.proj1.repositorio;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Entity;

import com.example.proj1.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
//JPA simples
@Repository
public class Clientes {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Cliente atualizar(Cliente cliente){
        em.merge(cliente);
        return cliente;
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        em.persist(cliente);     
        return cliente;
    }

    @Transactional
    public void deletar(Cliente e) {
        if(!em.contains(e))
            e = em.merge(e);
        em.remove(e);
    }

    @Transactional
    public void deletarId(Integer id){
        Cliente c = em.find(Cliente.class, id);//achar o objeto correspondente no bd
        deletar(c);
    }

    @Transactional
public List<Cliente> buscaNome(String nome) {
    String jpqlString = "SELECT c FROM Cliente c WHERE c.name LIKE :nome";
    TypedQuery<Cliente> query = em.createQuery(jpqlString, Cliente.class);
    query.setParameter("nome", "%" + nome + "%");
    return query.getResultList();
}


     @Transactional
    public List<Cliente> obterTodos() {
        return em.createQuery("from Cliente",Cliente.class).getResultList();
    }  
    

}
