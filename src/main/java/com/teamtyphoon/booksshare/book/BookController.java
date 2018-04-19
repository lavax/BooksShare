package com.teamtyphoon.booksshare.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@Autowired
	private BookService bs;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(Book book) {
		return "book/list";
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

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ModelAndView create(Book book) {
		bs.save(book);
		Iterable<Book> books = bs.getAll();
		ModelAndView modelAndView = new ModelAndView("book/list");
		modelAndView.addObject("books", books);
		return modelAndView;
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		bs.delete(id);
		return "book/list";
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

}