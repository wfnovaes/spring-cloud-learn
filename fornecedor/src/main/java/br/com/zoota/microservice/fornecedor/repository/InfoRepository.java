package br.com.zoota.microservice.fornecedor.repository;

import br.com.zoota.microservice.fornecedor.model.InformacaoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InformacaoFornecedor, Long> {

    InformacaoFornecedor findByUf(String uf);

}
