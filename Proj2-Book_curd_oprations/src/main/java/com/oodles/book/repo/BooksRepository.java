package com.oodles.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oodles.book.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

	List<Books> findAllByBookname(String name);




}
