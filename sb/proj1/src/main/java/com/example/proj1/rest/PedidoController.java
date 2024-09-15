package com.example.proj1.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import com.example.proj1.entities.ItemPedido;
import com.example.proj1.entities.Pedido;
import com.example.proj1.entities.StatusPedido;
import com.example.proj1.rest.dto.InfoPedidoDTO;
import com.example.proj1.rest.dto.PedidoDTO;
import com.example.proj1.rest.dto.attStatusDTO;
import com.example.proj1.rest.dto.infoItemPedidoDTO;
import com.example.proj1.service.PedidosService;

import jakarta.validation.Valid;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidosService ps;

    public PedidoController(PedidosService ps) {
        this.ps = ps;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody @Valid PedidoDTO pDto) {
        Pedido p = ps.salvar(pDto);
        return p.getId();
    }

    @GetMapping("{id}")
    public InfoPedidoDTO getById(@PathVariable Integer id) {
        return ps.obterPedido(id)
                 .map(this::convert)
                 .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pedido não encontrado"));
    }

    @PatchMapping("{id}")
    @ResponseStatus(NOT_FOUND)
    public void updateStatus(@PathVariable Integer id,@RequestBody attStatusDTO a){
        String s = a.getNovoStatus();
        ps.attStatus(id, StatusPedido.valueOf(s));
    }

    private InfoPedidoDTO convert(Pedido p) {
        InfoPedidoDTO d = new InfoPedidoDTO(p.getId(),p.getCliente().getCpf(),p.getCliente().getName(),p.getTotal(),convert(p.getItens()),p.getStatus().name(),p.getData());

        return d;
    }

    private List<infoItemPedidoDTO> convert(List<ItemPedido> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }

        return list.stream()
                .map(item -> infoItemPedidoDTO.builder()
                        .descricao(item.getProduto().getNome())
                        .preco(item.getProduto().getPreco())
                        .quantidade(item.getQuant())
                        .build())
                .collect(Collectors.toList());
    }
}
