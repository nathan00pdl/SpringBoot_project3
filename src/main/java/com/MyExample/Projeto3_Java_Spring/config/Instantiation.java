package com.MyExample.Projeto3_Java_Spring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MyExample.Projeto3_Java_Spring.domain.Post;
import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.repositories.PostRepository;
import com.MyExample.Projeto3_Java_Spring.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	//Declarando "Injeções de dependências"
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Limpando a collection do MongoDB
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//Instanciando usuários
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Instanciando Posts
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", u1);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Bora para mais um diazão!", u1);
		
		//Salvando usuários e posts instancidos no MongoDB
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
