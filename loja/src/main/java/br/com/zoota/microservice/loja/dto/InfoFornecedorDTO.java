package br.com.zoota.microservice.loja.dto;

import lombok.Data;

@Data
public class InfoFornecedorDTO {
    private Long id;
    private String nome;
    private String uf;
    private String endereco;
}
