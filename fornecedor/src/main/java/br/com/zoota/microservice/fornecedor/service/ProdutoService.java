package br.com.zoota.microservice.fornecedor.service;


import br.com.zoota.microservice.fornecedor.model.Produto;
import br.com.zoota.microservice.fornecedor.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getProdutosPorEstado(String uf) {
		log.info("Invocando getProdutosPorEstado(String uf); {}", uf);
		return produtoRepository.findByUf(uf);
	}

	
}
