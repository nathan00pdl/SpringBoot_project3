package com.MyExample.Projeto3_Java_Spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")  //Indica ao MongoDB que a classe 'User' será uma coleção
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String name;
	private String email;
	
	//Declarando Associações
	@DBRef(lazy = true)  //Indica que há uma referência par auma nova coleção no MongoDB
	private List<Post> posts = new ArrayList<>();
	
	//Declarando Construtores
	public User() {}

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	//Declarando métodos Equals e HashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
