package com.MyExample.Projeto3_Java_Spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	//Declarando "Injeções de dependências"
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Limpando a collection do MongoDB
		userRepository.deleteAll();
		
		//Instanciando usuários
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Salvando usuários instancidos no MongoDB
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}
}
