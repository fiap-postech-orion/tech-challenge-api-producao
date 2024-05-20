package br.com.postech.software.architecture.techchallenge.produto.model;

import br.com.postech.software.architecture.techchallenge.produto.enums.CategoriaEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Produto {

    private Long id;
    private String nome;
    private CategoriaEnum categoria;
    private BigDecimal valor;
    private String descricao;
    private List<ProdutoImagens> imagens;

}
