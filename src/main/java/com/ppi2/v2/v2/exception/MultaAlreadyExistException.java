package com.ppi2.v2.v2.exception;

public class MultaAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MultaAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public MultaAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
