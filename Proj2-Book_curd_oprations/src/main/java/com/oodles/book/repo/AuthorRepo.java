package com.oodles.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.book.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

	Author findAllById(Long id);

	List<Author> findAllByIdIn(List<Author> author);	
	


}
