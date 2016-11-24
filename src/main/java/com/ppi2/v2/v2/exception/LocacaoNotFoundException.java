package com.ppi2.v2.v2.exception;

public class LocacaoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LocacaoNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public LocacaoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
