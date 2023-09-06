package com.MyExample.Projeto3_Java_Spring.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.dto.UserDTO;
import com.MyExample.Projeto3_Java_Spring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//Declarando "injeção de dependência" para os serviço
	
	@Autowired
	private UserService service;
	
	
	//Declarando de endpoints:
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		//(TESTE)
		//Instanciando usuários de forma manual, para poder fazer a requisição no Postman 
		//User maria = new User("1", "Maria Brown", "ma@gmail.com");
		//List<User> list = new ArrayList<>();
		//list.addAll(Arrays.asList(maria));
		//return ResponseEntity.ok().body(list);
		
		
		//Recuperando usuários direto do MongoDB
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());  //Conversão de cada elemento da lista 'list' em um elemento do tipo DTO
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		//Recuperando usuários direto do MongoDB pelo id
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}
