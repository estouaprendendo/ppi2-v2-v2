package com.ppi2.v2.v2.representation;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Avaria;

public class AvariaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;

	@JsonInclude(Include.NON_NULL)
	private String descricao;

	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;

	public AvariaRepresentation() {
	}

	public AvariaRepresentation(Avaria avaria) {
		this.identifier = avaria.getIdAvaria();
		this.descricao = avaria.getDescricao();
	}

	public static Avaria build(AvariaRepresentation representation) {
		Avaria avaria = new Avaria();
		avaria.setIdAvaria(representation.getIdentifier());
		avaria.setDescricao(representation.getDescricao());
		return avaria;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}