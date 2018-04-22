package com.teamtyphoon.booksshare.book;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBookSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Resource bookCover;

	public void setBookCover(Resource bookCoverUrl) throws IOException {
		this.bookCover = bookCoverUrl;
	}

	public Resource getBookCover() {
		return bookCover;
	}

}