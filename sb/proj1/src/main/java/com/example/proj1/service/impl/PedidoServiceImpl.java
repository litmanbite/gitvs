package com.example.proj1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.ItemPedido;
import com.example.proj1.entities.Pedido;
import com.example.proj1.entities.Produto;
import com.example.proj1.repositorio.Clientes;
import com.example.proj1.repositorio.Itens;
import com.example.proj1.repositorio.Pedidos;
import com.example.proj1.repositorio.Produtos;
import com.example.proj1.rest.dto.ItemPedidoDTO;
import com.example.proj1.rest.dto.PedidoDTO;
import com.example.proj1.service.PedidosService;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

import com.example.proj1.Excep.Exception;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service//permite que ela seja injetada
public class PedidoServiceImpl implements PedidosService{
    //a anotação requieredargsconstructor faz o contrudor de tudo que eh final
    private final Pedidos repository;
    private final Clientes clientesReps;
    private final Produtos produtosReps;
    private final Itens itemPedidoReps;
  
    @Override
    @Transactional//realiza o rollback caso ocorra um erro
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        if (idCliente == null) {
            throw new IllegalArgumentException("ID do cliente não pode ser nulo");
        }
        Cliente c = clientesReps.findById(idCliente).orElseThrow(()-> new Exception("Codigo invalido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setData(LocalDate.now());
        pedido.setCliente(c);
        
        List<ItemPedido> listI = converterItem(pedido, pedidoDTO.getItens());
        repository.save(pedido);
        itemPedidoReps.saveAll(listI);
        pedido.setItens(listI);
        return pedido;
    }

    private List<ItemPedido> converterItem(Pedido p, List<ItemPedidoDTO> l) {
        if (l == null || l.isEmpty()) {
            throw new Exception("Pedido deve ter itens");
        }
        return l.stream()
            .map(dto -> {
                Integer it = dto.getProduto();
                if (it == null) {
                    throw new IllegalArgumentException("ID do produto não pode ser nulo");
                }
                Produto pp = produtosReps.findById(it)
                    .orElseThrow(() -> new Exception("Produto invalido, codigo : " + it));
    
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setQuant(dto.getQuant());
                itemPedido.setPedido(p);
                itemPedido.setProduto(pp);
                return itemPedido;
            })
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedido(Integer id) {
        return repository.findByIdFetchItens(id);
    }
    
    
        
}
