package com.MyExample.Projeto3_Java_Spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.repositories.UserRepository;

@Service
public class UserService {

	//Declarando "injeção de dependência" para o recurso
	@Autowired
	private UserRepository repository;
	
	
	//Declarando endpoints
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
