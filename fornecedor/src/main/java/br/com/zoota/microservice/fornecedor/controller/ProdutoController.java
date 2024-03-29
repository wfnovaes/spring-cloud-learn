package br.com.zoota.microservice.fornecedor.controller;


import br.com.zoota.microservice.fornecedor.model.Produto;
import br.com.zoota.microservice.fornecedor.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{uf}")
	public List<Produto> getProdutosPorEstado(@PathVariable String uf) {
		log.info("Invocando getProdutosPorEstado(String uf); {}", uf);
		return produtoService.getProdutosPorEstado(uf);
	}
}
