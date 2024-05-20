package br.com.postech.software.architecture.techchallenge.produto.model;

import lombok.Data;

@Data
public class PedidoProduto {

	private Produto produto;
    private Integer quantidade;

}
