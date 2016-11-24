package com.ppi2.v2.v2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;
	private String marca;
	private String modelo;

	@OneToMany(mappedBy = "veiculo")
	private List<Locacao> locacaos;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;

	public Veiculo() {
		super();
	}

	public Veiculo(Long idVeiculo, String marca, String modelo, List<Locacao> locacaos, Categoria categoria) {
		super();
		this.idVeiculo = idVeiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.locacaos = locacaos;
		this.categoria = categoria;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
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

	public List<Locacao> getLocacaos() {
		return locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVeiculo == null) ? 0 : idVeiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (idVeiculo == null) {
			if (other.idVeiculo != null)
				return false;
		} else if (!idVeiculo.equals(other.idVeiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [idVeiculo=" + idVeiculo + ", marca=" + marca + ", modelo=" + modelo + ", locacaos=" + locacaos
				+ ", categoria=" + categoria + "]";
	}

}
