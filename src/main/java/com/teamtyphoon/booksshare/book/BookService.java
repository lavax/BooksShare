package com.teamtyphoon.booksshare.book;

import java.util.List;

public interface BookService {
	void save(Book book);

	Book findById(Long id);

	List<Book> findByName(String name);

//	List<Book> findByAuthor(String author);

	void delete(Long id);

	Iterable<Book> getAll();
}
