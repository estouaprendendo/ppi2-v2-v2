package com.ppi2.v2.v2.exception;

public class AvariaAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AvariaAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public AvariaAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
