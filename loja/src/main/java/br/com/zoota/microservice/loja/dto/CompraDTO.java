package br.com.zoota.microservice.loja.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompraDTO {

  private List<ItemCompraDTO> itens;
  private EnderecoDTO endereco;

  public String getUf() {
    return endereco.getUf();
  }
  
}
