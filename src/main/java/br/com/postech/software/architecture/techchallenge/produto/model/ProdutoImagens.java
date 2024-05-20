package br.com.postech.software.architecture.techchallenge.produto.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoImagens {

    @NotNull(message = "É obrigatório informar o caminho da imagem.")
    private String path;

}