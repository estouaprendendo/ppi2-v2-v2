package com.ppi2.v2.v2.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Multa;

public class MultaRepresentation extends ResourceSupport {
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String descricao;

	public MultaRepresentation() {

	}

	public MultaRepresentation(Multa multa) {
		this.identifier = multa.getIdMulta();
		this.descricao = multa.getDescricao();
	}

	public static Multa build(MultaRepresentation representation) {
		Multa multa = new Multa();
		multa.setIdMulta(representation.getIdentifier());
		multa.setDescricao(representation.getDescricao());

		return multa;
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

}
