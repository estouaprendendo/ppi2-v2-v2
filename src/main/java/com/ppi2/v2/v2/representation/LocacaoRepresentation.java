package com.ppi2.v2.v2.representation;

import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ppi2.v2.v2.domain.Cliente;
import com.ppi2.v2.v2.domain.Funcionario;
import com.ppi2.v2.v2.domain.Locacao;
import com.ppi2.v2.v2.domain.Veiculo;

public class LocacaoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;

	@JsonInclude(Include.NON_NULL)
	private Date data;

	@JsonInclude(Include.NON_NULL)
	private ClienteRepresentation cliente;

	@JsonInclude(Include.NON_NULL)
	private FuncionarioRepresentation funcionarioCad;

	@JsonInclude(Include.NON_NULL)
	private FuncionarioRepresentation funcionarioRec;

	@JsonInclude(Include.NON_NULL)
	private VeiculoRepresentation veiculo;

	public LocacaoRepresentation() {

	}

	public LocacaoRepresentation(Locacao locacao) {
		this.identifier = locacao.getIdLocacao();
		this.data = locacao.getData();

		if (locacao.getCliente() != null) {
			Cliente cliente = locacao.getCliente();
			ClienteRepresentation clienteRepresentation = new ClienteRepresentation(cliente);
			this.setCliente(clienteRepresentation);
		}

		if (locacao.getFuncionarioCad() != null) {
			Funcionario funcionarioCad = locacao.getFuncionarioCad();
			FuncionarioRepresentation funcionarioRepresentation = new FuncionarioRepresentation(funcionarioCad);
			this.setFuncionarioCad(funcionarioRepresentation);
		}

		if (locacao.getFuncionarioRec() != null) {
			Funcionario funcionarioRec = locacao.getFuncionarioRec();
			FuncionarioRepresentation funcionarioRepresentation = new FuncionarioRepresentation(funcionarioRec);
			this.setFuncionarioRec(funcionarioRepresentation);
		}

		if (locacao.getVeiculo() != null) {
			Veiculo veiculo = locacao.getVeiculo();
			VeiculoRepresentation veiculoRepresentation = new VeiculoRepresentation(veiculo);
			this.setVeiculo(veiculoRepresentation);
		}

	}

	public static Locacao build(LocacaoRepresentation locacaoRepresentation) {
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(locacaoRepresentation.getIdentifier());
		locacao.setData(locacaoRepresentation.getData());

		if (locacaoRepresentation.getCliente() != null) {
			ClienteRepresentation clienteRepresentation = locacaoRepresentation.getCliente();
			Cliente cliente = ClienteRepresentation.build(clienteRepresentation);
			locacao.setCliente(cliente);
		}

		if (locacaoRepresentation.getFuncionarioCad() != null) {
			FuncionarioRepresentation funcionarioRepresentation = locacaoRepresentation.getFuncionarioCad();
			Funcionario funcionario = FuncionarioRepresentation.build(funcionarioRepresentation);
			locacao.setFuncionarioCad(funcionario);
		}

		if (locacaoRepresentation.getFuncionarioRec() != null) {
			FuncionarioRepresentation funcionarioRepresentation = locacaoRepresentation.getFuncionarioRec();
			Funcionario funcionario = FuncionarioRepresentation.build(funcionarioRepresentation);
			locacao.setFuncionarioRec(funcionario);
		}

		if (locacaoRepresentation.getVeiculo() != null) {
			VeiculoRepresentation veiculoRepresentation = locacaoRepresentation.getVeiculo();
			Veiculo veiculo = VeiculoRepresentation.build(veiculoRepresentation);
			locacao.setVeiculo(veiculo);
		}

		return locacao;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ClienteRepresentation getCliente() {
		return cliente;
	}

	public void setCliente(ClienteRepresentation cliente) {
		this.cliente = cliente;
	}

	public FuncionarioRepresentation getFuncionarioCad() {
		return funcionarioCad;
	}

	public void setFuncionarioCad(FuncionarioRepresentation funcionarioCad) {
		this.funcionarioCad = funcionarioCad;
	}

	public FuncionarioRepresentation getFuncionarioRec() {
		return funcionarioRec;
	}

	public void setFuncionarioRec(FuncionarioRepresentation funcionarioRec) {
		this.funcionarioRec = funcionarioRec;
	}

	public VeiculoRepresentation getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoRepresentation veiculo) {
		this.veiculo = veiculo;
	}

}
