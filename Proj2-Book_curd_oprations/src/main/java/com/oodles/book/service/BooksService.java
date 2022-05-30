package com.oodles.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.book.model.Author;
import com.oodles.book.model.Books;
import com.oodles.book.repo.AuthorRepo;
import com.oodles.book.repo.BooksRepository;

@Service
public class BooksService{
	
	@Autowired
	BooksRepository booksRepository;
	
	@Autowired
	private AuthorRepo repo;
	
	//getting all book record by using the find all method 
	public List <Books>  getAllBooks()
	{
		//List <Books> books =new ArrayList<Books>();
		return booksRepository.findAll();
		
	}
	
	//getting a specific record by using the method findById() of CrudRepository  
		public Books getBooksById(Long id) {
			return booksRepository.findById(id).get();
		}
		
		//saving a specific record by using the method save() of CrudRepository  
		public void saveOrUpdate(Books books)   
		{  
			List<Author> list = new ArrayList<Author>();	
			for(Author i :books.getAuthor()) {
				Author a = repo.findAllById(i.getId());
				list.add(a);
			}
			Books b = new Books();
			b.setBookname(books.getBookname());
			b.setAuthor(books.getAuthor());
			b.setPrice(books.getPrice());
			booksRepository.save(b);  
		
		}  
		
		
		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(Long id)   
		{  
			booksRepository.deleteById(id); 		
		}  
		//updating a record  
		public void update(Books books, int bookid)   
		{  
		booksRepository.save(books);  
		}

		public List<Books> getBooksByName(String name) {
			return booksRepository.findAllByBookname(name);
		}  
	}  

