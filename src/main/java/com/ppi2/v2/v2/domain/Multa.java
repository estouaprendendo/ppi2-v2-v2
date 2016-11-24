package com.ppi2.v2.v2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Multa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMulta;
	private String descricao;

	@ManyToMany
	@JoinTable(name = "locacaomulta", joinColumns = { @JoinColumn(name = "idMulta") }, inverseJoinColumns = {
			@JoinColumn(name = "idLocacao") })
	private List<Locacao> locacaos;

	public Multa() {
		super();
	}

	public Multa(Long idMulta, String descricao, List<Locacao> locacaos) {
		super();
		this.idMulta = idMulta;
		this.descricao = descricao;
		this.locacaos = locacaos;
	}

	public Long getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(Long idMulta) {
		this.idMulta = idMulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Locacao> getLocacaos() {
		return locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMulta == null) ? 0 : idMulta.hashCode());
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
		Multa other = (Multa) obj;
		if (idMulta == null) {
			if (other.idMulta != null)
				return false;
		} else if (!idMulta.equals(other.idMulta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Multa [idMulta=" + idMulta + ", descricao=" + descricao + ", locacaos=" + locacaos + "]";
	}

}
