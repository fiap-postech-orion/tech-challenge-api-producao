package br.com.postech.software.architecture.techchallenge.produto.model;

import lombok.Data;

@Data
public class Cliente {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private Boolean status;

	public void update(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.status = cliente.getStatus();
	}

}
