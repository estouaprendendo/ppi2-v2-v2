package com.ppi2.v2.v2.exception;

public class FuncionarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public FuncionarioNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
