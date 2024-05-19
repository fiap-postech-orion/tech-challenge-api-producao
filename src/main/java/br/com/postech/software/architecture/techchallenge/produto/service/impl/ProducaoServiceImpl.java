package br.com.postech.software.architecture.techchallenge.produto.service.impl;

import br.com.postech.software.architecture.techchallenge.produto.dto.PedidoDTO;
import br.com.postech.software.architecture.techchallenge.produto.dto.ProducaoUpdateDTO;
import br.com.postech.software.architecture.techchallenge.produto.exception.BusinessException;
import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProducao;
import br.com.postech.software.architecture.techchallenge.produto.repository.PedidoJpaRepository;
import br.com.postech.software.architecture.techchallenge.produto.repository.PedidoProducaoRepository;
import br.com.postech.software.architecture.techchallenge.produto.service.ProducaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProducaoServiceImpl implements ProducaoService {

	private final PedidoProducaoRepository repository;

	@Override
	public List<PedidoProducao> findAllByStatusPedido(String status) throws BusinessException{
		return repository.findAllByStatus(status);
	}

	@Override
	public PedidoProducao findByNumeroPedido(Long numeroPedido) throws BusinessException {
		Optional<PedidoProducao> optPedidoProducao = repository.findByNumeroPedido(numeroPedido);
		if(optPedidoProducao.isPresent()){
			return optPedidoProducao.get();
		}
		throw new BusinessException("Pedido não encontrado");
	}

	private Optional<PedidoProducao> findByUuid(String uuid) throws BusinessException {
		return repository.findByUuid(uuid);
	}

	@Override
	public PedidoProducao salvaPedido(PedidoProducao newPedidoProducao) {
		/*
		 * 1. Busca na base pelo id do pedido se existe registro
		 * 2. Se existir, atualizar,
		 * 3. Se não existir, criar
		 * 4. Retornar registro atualizado
		 */

		Optional<PedidoProducao> optPedidoProducao = findByUuid(newPedidoProducao.getUuid());
		if(optPedidoProducao.isPresent()){
			PedidoProducao existingPedidoProducao = optPedidoProducao.get();
			existingPedidoProducao.update(newPedidoProducao);
			return repository.save(existingPedidoProducao);
		}
		else {
			return repository.save(newPedidoProducao);
		}
	}
}
