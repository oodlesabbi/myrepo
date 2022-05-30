package com.oodles.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.book.model.Author;
import com.oodles.book.repo.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo repo;
	
	public List<Author>  getAllAuthor()
	{
		//List <Author> author =new ArrayList<Author>();
		
		return (List<Author>) repo.findAll();
		
	}
	
	//getting a specific record by using the method findById() of CrudRepository  
		public Author getAuthorById(Long id) {
			return repo.findById(id).get();
		}
		
		//saving a specific record by using the method save() of CrudRepository  
		public void saveOrUpdate(Author author)   
		{  
			Author b = new Author();
			b.setName(author.getName());
			b.setId(author.getId());
			b.setAddress(author.getAddress());
			repo.save(b);  
		}  
		
		
		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(Long id)   
		{  
			repo.deleteById(id); 		
		}  
		//updating a record  
		public void update(Author author, Long id)   
		{  
			repo.save(author);  
		}  	
	
}
