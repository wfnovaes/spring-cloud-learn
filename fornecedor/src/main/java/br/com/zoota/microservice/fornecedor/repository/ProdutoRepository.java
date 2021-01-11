package br.com.zoota.microservice.fornecedor.repository;

import br.com.zoota.microservice.fornecedor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByUf(String uf);
	
	List<Produto> findByIdIn(List<Long> ids);
}
