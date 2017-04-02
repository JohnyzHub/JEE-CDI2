package org.myjee.cdi.practice.BookStore.service;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.entity.Book;
import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.numbergenerate.NumberGenerator;
import org.myjee.cdi.practice.plainpojo.plainpjo_author.InfiniteThread;

@Loggable
public class BookService {

	@Inject
	private Book book;

	/**
	 * @Inject private Author author;
	 */

	@Inject
	// @NumberFormat(value = DigitFormat.THIRTEEN, description = "Thirteen
	// Digits")
	private NumberGenerator numberGenerator;

	@Inject
	private InfiniteThread thread;

	public void createBook(String title, String authorName, Float price, String description) {
		thread.startThread();

		book.getAuthor().setName(authorName);
		book.setTitle(title);
		book.setPrice(price);
		book.setDescription(description);
		book.setNumber(numberGenerator.generateNumber());

	}
}