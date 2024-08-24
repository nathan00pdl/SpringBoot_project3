package com.MyExample.Projeto3_Java_Spring.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MyExample.Projeto3_Java_Spring.domain.Post;
import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.dto.UserDTO;
import com.MyExample.Projeto3_Java_Spring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//Declarando "injeção de dependência"
	
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
	
	
	
	//Implementando operações básicas de CRUD
	
	//Inserindo usuários - INSERT
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deletando usuários - DELETE 
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		//Recuperando usuários direto do MongoDB pelo id
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizando usuários - UPDATE
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id){
		User obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	
	//Retornando posts de um usuário
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
