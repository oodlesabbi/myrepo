package com.oodles.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oodles.book.model.Books;
import com.oodles.book.service.BooksService;


//make class as controller
@RestController
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	//creating a get mapping that retrive all the books from the database
	
	@GetMapping("/books")
	private List<Books> getAllBook(){
		
		List<Books> book= booksService.getAllBooks();
		
		return book;
	}
	
	@GetMapping("/books/{id}")
	private ResponseEntity<Books> getbyId(@PathVariable Long id){
		
		Books book= booksService.getBooksById(id);
		if(book==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	@GetMapping("/book1")
	private List<Books> getbyName(@RequestParam String name){
		
		List<Books> book=  booksService.getBooksByName(name);
		
		return book;
	}
	
	
   //creating a delete mapping that deletes a specified book  
	
	
	@DeleteMapping("/books/{bookid}")
	private void deleteBook(@PathVariable Long bookid) {
		booksService.delete(bookid);
	}
	
	////creating post mapping that post the book detail in the database  
	@PostMapping("/books")  
	private void saveBook(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	}  
	
	//creating put mapping that updates the book detail   	
	@PutMapping("/books")
	private Books update(@RequestBody Books books)
	{
		booksService.saveOrUpdate(books);
		return books;
	}	
}
