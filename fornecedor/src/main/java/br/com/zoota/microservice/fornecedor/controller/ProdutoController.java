package br.com.zoota.microservice.fornecedor.controller;


import br.com.zoota.microservice.fornecedor.model.Produto;
import br.com.zoota.microservice.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{uf}")
	public List<Produto> getProdutosPorEstado(@PathVariable String uf) {
		return produtoService.getProdutosPorEstado(uf);
	}
}
