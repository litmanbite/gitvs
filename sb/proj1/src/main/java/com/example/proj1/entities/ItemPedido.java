package com.example.proj1.entities;

public class ItemPedido {
    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quant;

    
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuant() {
        return quant;
    }
    public void setQuant(Integer quant) {
        this.quant = quant;
    }
    
    
}
