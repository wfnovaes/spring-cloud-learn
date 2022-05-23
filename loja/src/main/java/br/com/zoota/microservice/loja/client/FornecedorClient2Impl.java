package br.com.zoota.microservice.loja.client;

import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import br.com.zoota.microservice.loja.dto.InfoPedidoDTO;
import br.com.zoota.microservice.loja.dto.ItemCompraDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class FornecedorClient2Impl implements FornecedorClient2 {

    private final String SERVICE_NAME = "fornecedor";

    private RestTemplate restTemplate;

    @Autowired
    public FornecedorClient2Impl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public InfoFornecedorDTO informacaoEstado(String uf) {
        log.info("Invocando informacaoEstado(String uf); {}", uf);
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/info/" + uf, InfoFornecedorDTO.class);
    }

    @Override
    public InfoPedidoDTO realizarPedido(List<ItemCompraDTO> itens) {
        log.info("Invocando realizarPedido(List<ItemCompraDTO> itens); {}", itens);
        return restTemplate.postForObject("http://" + SERVICE_NAME + "/pedido", itens, InfoPedidoDTO.class);
    }
}
