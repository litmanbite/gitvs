package com.example.proj1.entities;

public class Cliente {
    private Integer id;
    private String name;
    
    public Cliente (){}
    public Cliente(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", name=" + name + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
