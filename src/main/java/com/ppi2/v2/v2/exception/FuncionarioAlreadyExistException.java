package com.ppi2.v2.v2.exception;

public class FuncionarioAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FuncionarioAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public FuncionarioAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
