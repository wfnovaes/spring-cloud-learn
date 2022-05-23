package br.com.zoota.microservice.loja.client;

import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import br.com.zoota.microservice.loja.dto.InfoPedidoDTO;
import br.com.zoota.microservice.loja.dto.ItemCompraDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FornecedorClient2 {

    InfoFornecedorDTO informacaoEstado(@PathVariable String uf);

    InfoPedidoDTO realizarPedido(List<ItemCompraDTO> itens);
}
