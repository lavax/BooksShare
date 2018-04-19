package com.teamtyphoon.booksshare.book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByName(String name);

//	List<Book> findByAuthors(String author);

}
