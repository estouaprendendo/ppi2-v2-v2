package com.ppi2.v2.v2.exception;

public class MultaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MultaNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public MultaNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
