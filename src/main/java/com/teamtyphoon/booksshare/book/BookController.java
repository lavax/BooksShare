package com.teamtyphoon.booksshare.book;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bs;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView books() {
		return bookList();
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String edit(Book book) {
		return "book/edit";
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable Long id) {
		Book book = bs.findById(id);
		ModelAndView modelAndView = new ModelAndView("book/detail");
		modelAndView.addObject("book", book);
		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ModelAndView create(@Valid Book book) {
		bs.save(book);
		return bookList();
	}

	@Transactional
	@RequestMapping(value = "/book", method = RequestMethod.DELETE)
	public ModelAndView delete(String delete) {
		Long id = Long.valueOf(delete);
		logger.debug("Delete book id : {}", id);
		bs.delete(id);
		return bookList();
	}

	//
	// @InitBinder
	// public void bindingPreparation(WebDataBinder binder) {
	//
	// PropertyEditorSupport longToStringEditor = new LongToStringEditor();
	// binder.registerCustomEditor(Long.class, "id", longToStringEditor);
	// }
	//
	// class LongToStringEditor extends PropertyEditorSupport {
	// }
	private ModelAndView bookList() {
		Iterable<Book> books = bs.getAll();
		ModelAndView modelAndView = new ModelAndView("book/list");
		modelAndView.addObject("books", books);
		return modelAndView;
	}

}