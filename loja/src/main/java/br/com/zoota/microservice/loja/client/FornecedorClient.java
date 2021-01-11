package br.com.zoota.microservice.loja.client;

import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{uf}")
    InfoFornecedorDTO informacaoEstado(@PathVariable String uf);
}
