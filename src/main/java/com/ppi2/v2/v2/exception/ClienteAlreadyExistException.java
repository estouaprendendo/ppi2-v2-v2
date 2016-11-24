package com.ppi2.v2.v2.exception;

public class ClienteAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
