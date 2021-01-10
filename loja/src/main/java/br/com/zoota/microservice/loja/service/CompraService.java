package br.com.zoota.microservice.loja.service;

import br.com.zoota.microservice.loja.dto.CompraDTO;
import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    public void comprar(CompraDTO compra) {
        InfoFornecedorDTO response = client.getForObject("http://fornecedor/info/" + compra.getUf(), InfoFornecedorDTO.class);
        System.out.println(response.getEndereco());
    }
}
