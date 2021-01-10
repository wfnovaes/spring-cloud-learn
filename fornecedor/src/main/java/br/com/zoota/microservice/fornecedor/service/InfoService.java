package br.com.zoota.microservice.fornecedor.service;

import br.com.zoota.microservice.fornecedor.model.InformacaoFornecedor;
import br.com.zoota.microservice.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InformacaoFornecedor buscarInformacaoEstado(String uf) {
        return infoRepository.findByUf(uf);
    }
}
