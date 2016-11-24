package com.ppi2.v2.v2.exception;

public class CategoriaAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoriaAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public CategoriaAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
