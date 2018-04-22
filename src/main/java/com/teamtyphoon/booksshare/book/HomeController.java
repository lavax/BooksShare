package com.teamtyphoon.booksshare.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private BookService bs;

	@RequestMapping("/")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("book/list");
		modelAndView.addObject("books", bs.getAll());
		return modelAndView;
	}
}