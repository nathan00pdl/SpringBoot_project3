package com.MyExample.Projeto3_Java_Spring.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto3_Java_Spring.domain.Post;
import com.MyExample.Projeto3_Java_Spring.resources.util.URL;
import com.MyExample.Projeto3_Java_Spring.services.PostService;

@RestController
@RequestMapping(value = "/users")
public class PostResource {

	//Declarando "injeção de dependência"
	
	@Autowired
	private PostService service;
	
	
	//Declarando de endpoints:
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.FinfByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
	        @RequestParam(value = "minDate", defaultValue = "") String minDate,
	        @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
				
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0));
		Date max = URL.convertDate(minDate, new Date());
		
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
