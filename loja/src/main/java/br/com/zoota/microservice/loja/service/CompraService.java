package br.com.zoota.microservice.loja.service;

import br.com.zoota.microservice.loja.client.FornecedorClient;
import br.com.zoota.microservice.loja.client.FornecedorClient2;
import br.com.zoota.microservice.loja.dto.CompraDTO;
import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import br.com.zoota.microservice.loja.dto.InfoPedidoDTO;
import br.com.zoota.microservice.loja.model.Compra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompraService {

    private FornecedorClient fornecedorClient;
    private FornecedorClient2 fornecedorClient2;

    @Autowired
    public CompraService(FornecedorClient fornecedorClient, FornecedorClient2 fornecedorClient2) {
        this.fornecedorClient = fornecedorClient;
        this.fornecedorClient2 = fornecedorClient2;
    }

    public Compra comprar(CompraDTO compra) {
        log.info("Invocando comprar(CompraDTO compra); {}", compra);
        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient2.informacaoEstado(compra.getUf());
        InfoPedidoDTO infoPedidoDTO = fornecedorClient2.realizarPedido(compra.getItens());
        return gerarCompraSalva(compra, infoPedidoDTO);
    }

    private Compra gerarCompraSalva(CompraDTO compra, InfoPedidoDTO infoPedidoDTO) {
        return Compra.builder()
                .pedidoId(infoPedidoDTO.getId())
                .tempoPreparo(infoPedidoDTO.getTempoDePreparo())
                .enderecoEntrega(compra.getEndereco().toString())
                .build();
    }
}
