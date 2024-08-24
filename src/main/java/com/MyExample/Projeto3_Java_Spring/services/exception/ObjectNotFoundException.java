package com.MyExample.Projeto3_Java_Spring.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	//Declarando Construtores
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
