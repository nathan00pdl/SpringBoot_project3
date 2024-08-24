package com.MyExample.Projeto3_Java_Spring.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	
	//Declarando Associação
	private AuthorDTO author;
	
	//Declarando Construtores
	public CommentDTO() {}

	public CommentDTO(String text, Date date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	
	//Declarando métodos getters e setters 
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	public AuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
