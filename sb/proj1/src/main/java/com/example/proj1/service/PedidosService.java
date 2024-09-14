package com.example.proj1.service;

import java.util.Optional;

import com.example.proj1.entities.Pedido;
import com.example.proj1.entities.StatusPedido;
import com.example.proj1.rest.dto.PedidoDTO;

public interface PedidosService {
    Pedido salvar (PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedido (Integer id);

    void attStatus(Integer id, StatusPedido s);
}
