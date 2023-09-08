package com.MyExample.Projeto3_Java_Spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.MyExample.Projeto3_Java_Spring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//Declarando métodos responsáveis pelas queries
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
