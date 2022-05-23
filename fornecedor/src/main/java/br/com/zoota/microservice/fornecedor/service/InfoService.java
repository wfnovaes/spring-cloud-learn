package br.com.zoota.microservice.fornecedor.service;

import br.com.zoota.microservice.fornecedor.model.InformacaoFornecedor;
import br.com.zoota.microservice.fornecedor.repository.InfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InfoService {

    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public InformacaoFornecedor buscarInformacaoEstado(String uf) {
        log.info("Invocando buscarInformacaoEstado(String uf); {}", uf);
        return infoRepository.findByUf(uf);
    }
}
