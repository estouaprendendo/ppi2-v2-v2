package com.ppi2.v2.v2.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Categoria;
import com.ppi2.v2.v2.domain.Veiculo;

public class VeiculoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private String marca;
	@JsonInclude(Include.NON_NULL)
	private String modelo;
	@JsonInclude(Include.NON_NULL)
	private CategoriaRepresentation categoria;

	public VeiculoRepresentation() {
		super();
	}

	public VeiculoRepresentation(Veiculo veiculo) {
		super();
		this.identifier = veiculo.getIdVeiculo();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();

		if (veiculo.getCategoria() != null) {
			Categoria categoria = veiculo.getCategoria();
			CategoriaRepresentation categoriaRepresentation = new CategoriaRepresentation(categoria);
			this.setCategoria(categoriaRepresentation);
		}
	}

	public static Veiculo build(VeiculoRepresentation veiculoRepresentation) {
		Veiculo veiculo = new Veiculo();
		veiculo.setIdVeiculo(veiculoRepresentation.getIdentifier());
		veiculo.setMarca(veiculoRepresentation.getMarca());
		veiculo.setModelo(veiculoRepresentation.getModelo());

		if (veiculoRepresentation.getCategoria() != null) {
			CategoriaRepresentation categoriaRepresentation = veiculoRepresentation.getCategoria();
			Categoria categoria = CategoriaRepresentation.build(categoriaRepresentation);
			veiculo.setCategoria(categoria);
		}

		return veiculo;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public CategoriaRepresentation getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaRepresentation categoria) {
		this.categoria = categoria;
	}

}
