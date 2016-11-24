package com.ppi2.v2.v2.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Cliente;

public class ClienteRepresentation extends ResourceSupport {
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String cpf;
	@JsonInclude(Include.NON_NULL)
	private String nome;

	public ClienteRepresentation() {

	}

	public ClienteRepresentation(Cliente cliente) {
		this.identifier = cliente.getIdCliente();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();

	}

	public static Cliente build(ClienteRepresentation representation) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(representation.getIdentifier());
		cliente.setCpf(representation.getCpf());
		cliente.setNome(representation.getNome());
		return cliente;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
