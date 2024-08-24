package com.MyExample.Projeto3_Java_Spring.dto;

import java.io.Serializable;

import com.MyExample.Projeto3_Java_Spring.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	
	//Declarando Construtores
	public AuthorDTO() {}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	
	//Declaradno métodos getters e setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
