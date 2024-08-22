package com.example.proj1.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    @Column(name = "preco_unitario")
    private BigDecimal preco;
      
    @Column(name = "nome")   
    private String nome;


    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
