package com.ppi2.v2.v2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Avaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaria;
	private String descricao;

	@ManyToMany(mappedBy = "avarias")
	private List<Locacao> locacaos;

	public Avaria() {
		super();
	}

	public Avaria(Long idAvaria, String descricao, List<Locacao> locacaos) {
		super();
		this.idAvaria = idAvaria;
		this.descricao = descricao;
		this.locacaos = locacaos;
	}

	public Long getIdAvaria() {
		return idAvaria;
	}

	public void setIdAvaria(Long idAvaria) {
		this.idAvaria = idAvaria;
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
		result = prime * result + ((idAvaria == null) ? 0 : idAvaria.hashCode());
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
		Avaria other = (Avaria) obj;
		if (idAvaria == null) {
			if (other.idAvaria != null)
				return false;
		} else if (!idAvaria.equals(other.idAvaria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaria [idAvaria=" + idAvaria + ", descricao=" + descricao + ", locacaos=" + locacaos + "]";
	}

}
