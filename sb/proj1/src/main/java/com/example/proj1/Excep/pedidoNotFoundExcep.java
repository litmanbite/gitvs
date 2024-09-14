package com.example.proj1.Excep;

public class pedidoNotFoundExcep extends RuntimeException {
    public pedidoNotFoundExcep (){
        super("Pedido nao encontrado");
    }
}
