package br.com.postech.software.architecture.techchallenge.produto.configuration;

import br.com.postech.software.architecture.techchallenge.produto.enums.StatusPedidoEnum;
import org.modelmapper.AbstractConverter;

public class InteiroParaStatusPedidoConverter extends AbstractConverter<Integer, StatusPedidoEnum> {

	@Override
	protected StatusPedidoEnum convert(Integer source) {
		return StatusPedidoEnum.get(source);
	}

}
