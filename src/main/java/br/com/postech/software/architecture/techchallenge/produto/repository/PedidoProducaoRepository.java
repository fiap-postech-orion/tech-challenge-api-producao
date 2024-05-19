package br.com.postech.software.architecture.techchallenge.produto.repository;

import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProducao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoProducaoRepository extends MongoRepository<PedidoProducao, String> {

	@Query(value = "{statusPedido: '?0'}")
	List<PedidoProducao> findAllByStatus(String statusPedido);

	@Query(value = "{numeroPedido: '?0'}")
	Optional<PedidoProducao> findByNumeroPedido(Long numeroPedido);

	@Query(value = "{uuid: '?0'}")
	Optional<PedidoProducao> findByUuid(String uuid);
}
