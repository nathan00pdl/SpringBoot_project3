package com.MyExample.Projeto3_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.repositories.UserRepository;
import com.MyExample.Projeto3_Java_Spring.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	//Declarando "injeção de dependência" para o recurso
	@Autowired
	private UserRepository repository;
	
	
	//Declarando endpoints
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
