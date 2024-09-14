package com.example.proj1.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoPedidoDTO {
    private Integer codigo;
    private String cpf;
    private String nomeC;
    private BigDecimal total;
    private List<infoItemPedidoDTO> items; 
    private LocalDate dataPedido;
}
