package com.ppi2.v2.v2.exception;

public class VeiculoAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeiculoAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public VeiculoAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
