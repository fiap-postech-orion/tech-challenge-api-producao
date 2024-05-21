package br.com.postech.software.architecture.techchallenge.produto;

import br.com.postech.software.architecture.techchallenge.produto.model.Cliente;
import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProducao;
import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProduto;
import br.com.postech.software.architecture.techchallenge.produto.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PedidoProducaoTests {

	private PedidoProducao pedidoProducao;

	@BeforeEach
	public void setUp() {
		pedidoProducao = new PedidoProducao();
		pedidoProducao.setUuid("123e4567-e89b-12d3-a456-426614174000");
		pedidoProducao.setNumeroPedido(123L);

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente 1");
		cliente.setEmail("cliente1@example.com");
		pedidoProducao.setCliente(cliente);

		pedidoProducao.setDataPedido("2023-05-20");
		pedidoProducao.setStatusPedido("PENDENTE");

		PedidoProduto produto1 = new PedidoProduto();
		produto1.setProduto( mock(Produto.class));
		produto1.setQuantidade(2);

		PedidoProduto produto2 = new PedidoProduto();
		produto2.setProduto( mock(Produto.class));
		produto2.setQuantidade(3);

		pedidoProducao.setProdutos(Arrays.asList(produto1, produto2));
	}

	@Test
	public void testUpdate() {
		PedidoProducao novoPedidoProducao = new PedidoProducao();
		novoPedidoProducao.setStatusPedido("CONFIRMADO");

		Cliente novoCliente = mock(Cliente.class);
		novoPedidoProducao.setCliente(novoCliente);

		PedidoProduto produto3 = new PedidoProduto();
		produto3.setProduto(mock(Produto.class));
		produto3.setQuantidade(1);

		List<PedidoProduto> novosProdutos = Arrays.asList(produto3);
		novoPedidoProducao.setProdutos(novosProdutos);

		pedidoProducao.update(novoPedidoProducao);

		assertEquals("CONFIRMADO", pedidoProducao.getStatusPedido());
		verify(novoCliente, times(0)).update(any(Cliente.class));
		assertEquals(novosProdutos, pedidoProducao.getProdutos());
	}
}
