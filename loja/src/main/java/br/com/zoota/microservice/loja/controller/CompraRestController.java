package br.com.zoota.microservice.loja.controller;


import br.com.zoota.microservice.loja.dto.CompraDTO;
import br.com.zoota.microservice.loja.model.Compra;
import br.com.zoota.microservice.loja.service.CompraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/compra")
public class CompraRestController {

  @Autowired
  private CompraService compraService;

  @QueryMapping
  public String teste() {
    return "hello world";
  }

  @PostMapping
  @MutationMapping
  public Compra comprar(@RequestBody @Argument CompraDTO compra){
    log.info("Invocando metodo comprar(CompraDTO compra); {}", compra);
    Compra compraResposta = compraService.comprar(compra);
    log.info("Compra realizada com sucesso!");
    return  compraResposta;
  }

}