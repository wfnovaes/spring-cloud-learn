package br.com.zoota.microservice.loja.service;

import br.com.zoota.microservice.loja.client.FornecedorClient;
import br.com.zoota.microservice.loja.dto.CompraDTO;
import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void comprar(CompraDTO compra) {
        InfoFornecedorDTO response = fornecedorClient.informacaoEstado(compra.getUf());
        System.out.println(response.getEndereco());
    }
}
