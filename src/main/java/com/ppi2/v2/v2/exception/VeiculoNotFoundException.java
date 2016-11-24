package com.ppi2.v2.v2.exception;

public class VeiculoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeiculoNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public VeiculoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
