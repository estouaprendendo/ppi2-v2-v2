package com.ppi2.v2.v2.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Categoria;

public class CategoriaRepresentation extends ResourceSupport {
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String descricao;

	public CategoriaRepresentation() {

	}

	public CategoriaRepresentation(Categoria categoria) {
		this.identifier = categoria.getIdCategoria();
		this.descricao = categoria.getDescricao();
	}

	public static Categoria build(CategoriaRepresentation categoriaRepresentation) {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaRepresentation.getIdentifier());
		categoria.setDescricao(categoriaRepresentation.getDescricao());
		return categoria;
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
