package br.com.postech.software.architecture.techchallenge.produto.service;

import br.com.postech.software.architecture.techchallenge.produto.exception.BusinessException;
import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProducao;

import java.util.List;

public interface ProducaoService {

	List<PedidoProducao> findAllByStatusPedido(String status) throws BusinessException;

	public PedidoProducao findByNumeroPedido(Long numeroPedido) throws BusinessException;

	PedidoProducao salvaPedido(PedidoProducao producaoUpdateDTO);
}
