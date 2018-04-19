package com.teamtyphoon.booksshare.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository br;

	@Override
	public void save(Book book) {
		br.save(book);
	}

	@Override
	public Book findById(Long id) {
		Optional<Book> findById = br.findById(id);
		return findById.get();
	}

	@Override
	public List<Book> findByName(String name) {
		List<Book> list = br.findByName(name);
		return list;
	}

	// @Override
	// public List<Book> findByAuthor(String author) {
	// List<Book> list = br.findByAuthors(author);
	// return list;
	// }

	@Override
	public void delete(Long id) {
		br.deleteById(id);
	}

	@Override
	public Iterable<Book> getAll() {
		return br.findAll();
	}

}
