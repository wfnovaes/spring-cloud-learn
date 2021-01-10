package br.com.zoota.microservice.fornecedor.controller;

import br.com.zoota.microservice.fornecedor.model.InformacaoFornecedor;
import br.com.zoota.microservice.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService inforService;

    @GetMapping("/{uf}")
    public InformacaoFornecedor informacaoEstado(@PathVariable String uf) {
        return inforService.buscarInformacaoEstado(uf);
    }
}
