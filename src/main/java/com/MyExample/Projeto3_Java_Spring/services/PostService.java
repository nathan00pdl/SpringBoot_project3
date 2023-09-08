package com.MyExample.Projeto3_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto3_Java_Spring.domain.Post;
import com.MyExample.Projeto3_Java_Spring.repositories.PostRepository;
import com.MyExample.Projeto3_Java_Spring.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	//Declarando "injeção de dependência"
	
	@Autowired
	private PostRepository repository;
	
	
	//Declarando endpoints
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> FinfByTitle(String text){
		return repository.findByTitleContaining(text);
	}
}
