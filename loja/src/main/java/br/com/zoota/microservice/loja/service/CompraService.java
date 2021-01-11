package br.com.zoota.microservice.loja.service;

import br.com.zoota.microservice.loja.client.FornecedorClient;
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

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra comprar(CompraDTO compra) {
        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.informacaoEstado(compra.getUf());
        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizarPedido(compra.getItens());
        return gerarCompraSalva(compra, infoPedidoDTO);
    }

    private Compra gerarCompraSalva(CompraDTO compra, InfoPedidoDTO infoPedidoDTO) {
        return Compra.builder()
                .pedidoId(infoPedidoDTO.getId())
                .tempoPreparo(infoPedidoDTO.getTempoPreparo())
                .enderecoEntrega(compra.getEndereco().toString())
                .build();
    }
}
