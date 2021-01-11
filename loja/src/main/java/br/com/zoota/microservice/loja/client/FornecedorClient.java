package br.com.zoota.microservice.loja.client;

import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import br.com.zoota.microservice.loja.dto.InfoPedidoDTO;
import br.com.zoota.microservice.loja.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{uf}")
    InfoFornecedorDTO informacaoEstado(@PathVariable String uf);

    @PostMapping("/pedido")
    InfoPedidoDTO realizarPedido(List<ItemCompraDTO> itens);
}
