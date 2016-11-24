package com.ppi2.v2.v2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;
	private String matricula;
	private String nome;

	@OneToMany(mappedBy = "funcionarioCad")
	private List<Locacao> locacaosCad;

	@OneToMany(mappedBy = "funcionarioRec")
	private List<Locacao> locacaosRec;

	public Funcionario() {
		super();
	}

	public Funcionario(Long idFuncionario, String matricula, String nome, List<Locacao> locacaosCad,
			List<Locacao> locacaosRec) {
		super();
		this.idFuncionario = idFuncionario;
		this.matricula = matricula;
		this.nome = nome;
		this.locacaosCad = locacaosCad;
		this.locacaosRec = locacaosRec;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public List<Locacao> getLocacaosCad() {
		return locacaosCad;
	}

	public void setLocacaosCad(List<Locacao> locacaosCad) {
		this.locacaosCad = locacaosCad;
	}

	public List<Locacao> getLocacaosRec() {
		return locacaosRec;
	}

	public void setLocacaosRec(List<Locacao> locacaosRec) {
		this.locacaosRec = locacaosRec;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", matricula=" + matricula + ", nome=" + nome
				+ ", locacaosCad=" + locacaosCad + ", locacaosRec=" + locacaosRec + "]";
	}

}
