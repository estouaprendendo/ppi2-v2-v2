package com.ppi2.v2.v2.exception;

public class AvariaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AvariaNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public AvariaNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}