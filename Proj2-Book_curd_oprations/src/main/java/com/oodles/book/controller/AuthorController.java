package com.oodles.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oodles.book.model.Author;
import com.oodles.book.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/author")
	private List<Author>getAllAuthor(){
		
		List<Author> author= service.getAllAuthor();
		
		return author;
	}
	
	
	@GetMapping("/author/{id}")
	private Author getAuthor(@PathVariable("id") Long id){
		
		Author author= service.getAuthorById(id);
		
		return author;
	}
	
	
	@PostMapping("/author")  
	private void saveAuthor(@RequestBody Author author)   
	{  
	service.saveOrUpdate(author);  
	}  

}
