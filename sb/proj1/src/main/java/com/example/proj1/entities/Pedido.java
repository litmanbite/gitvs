package com.example.proj1.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name ="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "data_pedido")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    
    @Column(name="total",length = 20, precision = 2)
    private BigDecimal total;
    
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    @OneToMany(mappedBy = "pedido")
    private ArrayList<ItemPedido> itens;

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }
    
}
