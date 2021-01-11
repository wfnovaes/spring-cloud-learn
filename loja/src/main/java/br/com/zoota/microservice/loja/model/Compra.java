package br.com.zoota.microservice.loja.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Compra {

    private Long pedidoId;

    private Integer tempoPreparo;

    private String enderecoEntrega;

}
