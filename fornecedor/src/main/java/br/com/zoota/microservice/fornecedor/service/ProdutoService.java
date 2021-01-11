package br.com.zoota.microservice.fornecedor.service;


import br.com.zoota.microservice.fornecedor.model.Produto;
import br.com.zoota.microservice.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String uf) {
		return produtoRepository.findByEstado(uf);
	}

	
}
