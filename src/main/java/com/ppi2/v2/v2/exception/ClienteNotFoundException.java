package com.ppi2.v2.v2.exception;

public class ClienteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
