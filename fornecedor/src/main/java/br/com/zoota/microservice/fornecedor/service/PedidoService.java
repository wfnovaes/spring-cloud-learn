package br.com.zoota.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zoota.microservice.fornecedor.model.Pedido;
import br.com.zoota.microservice.fornecedor.model.PedidoItem;
import br.com.zoota.microservice.fornecedor.model.PedidoStatus;
import br.com.zoota.microservice.fornecedor.model.Produto;
import br.com.zoota.microservice.fornecedor.repository.PedidoRepository;
import br.com.zoota.microservice.fornecedor.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zoota.microservice.fornecedor.dto.ItemDoPedidoDTO;

@Service
@Slf4j
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	public Pedido getPedidoPorId(Long id) {
		log.info("Invocando getPedidoPorId(Long id); {}", id);
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itensPedido) {
		log.info("Invocando realizaPedido(List<ItemDoPedidoDTO> itensPedido); {}", itensPedido);
		if(itensPedido == null) return null;
		
		List<PedidoItem> pedidoItens = toPedidoItem(itensPedido);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itensPedido.size());
		return pedidoRepository.save(pedido);
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itensPedido) {
		List<Long> idsProdutos = getIdsProdutos(itensPedido);
		List<Produto> produtos = produtoRepository.findByIdIn(idsProdutos);
		return gerarUmaListaDePedidoItem(itensPedido, produtos);
	}

	private List<Long> getIdsProdutos(List<ItemDoPedidoDTO> itens) {
		return itens
				.stream()
				.map(ItemDoPedidoDTO::getId)
				.collect(Collectors.toList());
	}

	private List<PedidoItem> gerarUmaListaDePedidoItem(List<ItemDoPedidoDTO> itensPedido, List<Produto> produtos) {
		return itensPedido
				.stream()
				.map(itemPedido -> gerarUmPedidoItem(itemPedido, produtos))
				.collect(Collectors.toList());
	}

	private PedidoItem gerarUmPedidoItem(ItemDoPedidoDTO itemPedido, List<Produto> produtos) {
		Produto produto = buscarProdutoCorrespondenteAoItemPedido(produtos, itemPedido.getId());
		PedidoItem pedidoItem = new PedidoItem();
		pedidoItem.setProduto(produto);
		pedidoItem.setQuantidade(itemPedido.getQuantidade());
		return pedidoItem;
	}

	private Produto buscarProdutoCorrespondenteAoItemPedido(List<Produto> produtosDoPedido, Long idItemLista) {
		return produtosDoPedido
				.stream()
				.filter(p -> p.getId().equals(idItemLista))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Produto não encontrado, item da lista: " + idItemLista));
	}
}
