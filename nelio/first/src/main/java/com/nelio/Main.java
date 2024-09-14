package com.nelio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com"); 
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com"); 
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com"); 

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
    

        em.getTransaction().begin();

        Pessoa p = em.find(Pessoa.class, 2);
        em.remove(p);


        em.getTransaction().commit();

        System.out.println(p.toString());

        em.close();
        emf.close();

    }
}