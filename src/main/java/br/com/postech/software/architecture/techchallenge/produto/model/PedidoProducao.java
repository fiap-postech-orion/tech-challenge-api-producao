package br.com.postech.software.architecture.techchallenge.produto.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection  = "PedidoProducao")
public class PedidoProducao {

    @Id
    private String uuid;
    private Long numeroPedido;
    private Cliente cliente;
    private String dataPedido;
    private String statusPedido;
    private List<PedidoProduto> produtos;

    public void update(PedidoProducao pedidoProducao) {
        this.statusPedido = pedidoProducao.getStatusPedido();
        this.cliente.update(pedidoProducao.getCliente());
        this.produtos = pedidoProducao.getProdutos();
    }
}
