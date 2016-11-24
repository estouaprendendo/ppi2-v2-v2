package com.ppi2.v2.v2.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocacao;
	private Date data;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idFuncionarioCad")
	private Funcionario funcionarioCad;

	@ManyToOne
	@JoinColumn(name = "idFuncionarioRec")
	private Funcionario funcionarioRec;

	@ManyToOne
	@JoinColumn(name = "idVeiculo")
	private Veiculo veiculo;

	@ManyToMany
	@JoinTable(name = "locacaoavaria", joinColumns = { @JoinColumn(name = "idLocacao") }, inverseJoinColumns = {
			@JoinColumn(name = "idAvaria") })
	private List<Avaria> avarias;

	@ManyToMany(mappedBy = "locacaos")
	private List<Multa> multas;

	public Locacao() {
		super();
	}

	public Locacao(Long idLocacao, Date data, Cliente cliente, Funcionario funcionarioCad, Funcionario funcionarioRec,
			Veiculo veiculo, List<Avaria> avarias, List<Multa> multas) {
		super();
		this.idLocacao = idLocacao;
		this.data = data;
		this.cliente = cliente;
		this.funcionarioCad = funcionarioCad;
		this.funcionarioRec = funcionarioRec;
		this.veiculo = veiculo;
		this.avarias = avarias;
		this.multas = multas;
	}

	public Long getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionarioCad() {
		return funcionarioCad;
	}

	public void setFuncionarioCad(Funcionario funcionarioCad) {
		this.funcionarioCad = funcionarioCad;
	}

	public Funcionario getFuncionarioRec() {
		return funcionarioRec;
	}

	public void setFuncionarioRec(Funcionario funcionarioRec) {
		this.funcionarioRec = funcionarioRec;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocacao == null) ? 0 : idLocacao.hashCode());
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
		Locacao other = (Locacao) obj;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Locacao [idLocacao=" + idLocacao + ", data=" + data + ", cliente=" + cliente + ", funcionarioCad="
				+ funcionarioCad + ", funcionarioRec=" + funcionarioRec + ", veiculo=" + veiculo + ", avarias="
				+ avarias + ", multas=" + multas + "]";
	}

}
