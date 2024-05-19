package br.com.postech.software.architecture.techchallenge.produto.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoProduto {

	private Produto produto;
    @NotNull(message = "A quantidade é obrigatório.")
    private Integer quantidade;
}
