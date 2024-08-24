package com.MyExample.Projeto3_Java_Spring.dto;

import java.io.Serializable;

import com.MyExample.Projeto3_Java_Spring.domain.User;

//OBS: Data Transfer Object (DTO) é um objeto que tem o papel de carregar dados das entidades de forma simples.

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	//Declarando Construtores
	public UserDTO() {}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	
	//Declarando métodos getters e setters
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
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
