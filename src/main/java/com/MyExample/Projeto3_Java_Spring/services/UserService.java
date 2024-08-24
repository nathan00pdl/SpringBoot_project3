package com.MyExample.Projeto3_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.dto.UserDTO;
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
	
	
	
	//Implementando operações básicas de CRUD
	
	//Inserindo usuários - INSERT
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	//Deletando usuários - DELETE
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	//Atualizando usuários - UPDATE
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	
	
	
	//Método que "pega" um DTO ('objDTO') e instancia um usuário
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
