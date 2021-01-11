package br.com.zoota.microservice.fornecedor.controller;

import java.util.List;

import br.com.zoota.microservice.fornecedor.model.Pedido;
import br.com.zoota.microservice.fornecedor.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.zoota.microservice.fornecedor.dto.ItemDoPedidoDTO;

@RestController
@Slf4j
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		log.info("Invocando realizaPedido(List<ItemDoPedidoDTO> produtos); {}", produtos);
		return pedidoService.realizaPedido(produtos);
	}
	
	@RequestMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		log.info("Invocando getPedidoPorId(Long id); {}", id);
		return pedidoService.getPedidoPorId(id);
	}
}
