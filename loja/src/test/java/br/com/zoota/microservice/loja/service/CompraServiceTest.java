package br.com.zoota.microservice.loja.service;

import br.com.zoota.microservice.loja.client.FornecedorClient;
import br.com.zoota.microservice.loja.client.FornecedorClient2;
import br.com.zoota.microservice.loja.dto.CompraDTO;
import br.com.zoota.microservice.loja.dto.EnderecoDTO;
import br.com.zoota.microservice.loja.dto.InfoFornecedorDTO;
import br.com.zoota.microservice.loja.dto.InfoPedidoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
class CompraServiceTest {

    @Mock
    FornecedorClient fornecedorClient;

    @Mock
    FornecedorClient2 fornecedorClient2;

    @InjectMocks
    CompraService compraService;

    @Test
    public void shouldSendAnOrder() {
        InfoFornecedorDTO infoFornecedorDTO = new InfoFornecedorDTO();
        InfoPedidoDTO infoPedidoDTO = new InfoPedidoDTO();

        Mockito.when(fornecedorClient2.informacaoEstado(Mockito.anyString())).thenReturn(infoFornecedorDTO);
        Mockito.when(fornecedorClient2.realizarPedido(Mockito.anyList())).thenReturn(infoPedidoDTO);

        CompraDTO compraDTO = CompraDTO.builder()
                .endereco(new EnderecoDTO("asda", "asdas", "SP"))
                .itens(Collections.EMPTY_LIST)
                .build();

        compraService.comprar(compraDTO);

        Mockito.verify(fornecedorClient2, new Times(1)).informacaoEstado(Mockito.anyString());
        Mockito.verify(fornecedorClient2, new Times(1)).informacaoEstado(Mockito.anyString());

    }

}