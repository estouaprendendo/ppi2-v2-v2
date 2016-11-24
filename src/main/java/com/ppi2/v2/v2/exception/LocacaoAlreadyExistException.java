package com.ppi2.v2.v2.exception;

public class LocacaoAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LocacaoAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public LocacaoAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
