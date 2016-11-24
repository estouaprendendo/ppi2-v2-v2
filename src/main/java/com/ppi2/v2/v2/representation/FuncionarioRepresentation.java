package com.ppi2.v2.v2.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Funcionario;

public class FuncionarioRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String matricula;
	@JsonInclude(Include.NON_NULL)
	private String nome;

	public FuncionarioRepresentation() {

	}

	public FuncionarioRepresentation(Funcionario funcionario) {
		this.identifier = funcionario.getIdFuncionario();
		this.matricula = funcionario.getMatricula();
		this.nome = funcionario.getNome();
	}

	public static Funcionario build(FuncionarioRepresentation representation) {
		Funcionario funcionario = new Funcionario();
		funcionario.setIdFuncionario(representation.getIdentifier());
		funcionario.setMatricula(representation.getMatricula());
		funcionario.setNome(representation.getNome());
		return funcionario;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
