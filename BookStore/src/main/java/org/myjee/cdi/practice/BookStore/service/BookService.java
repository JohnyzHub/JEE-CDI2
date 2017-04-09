package org.myjee.cdi.practice.BookStore.service;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.entity.Author;
import org.myjee.cdi.practice.BookStore.entity.Book;
import org.myjee.cdi.practice.BookStore.entity.Category;
import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.numbergenerate.NumberGenerator;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat.DigitFormat;
import org.myjee.cdi.practice.plainpojo.time.TimeTracker;

public class BookService {

	@Inject
	private Author author;

	@Inject
	private Book book;

	@NumberFormat(value = DigitFormat.THIRTEEN, description = "Thirteen Digits")
	@Inject
	private NumberGenerator numberGenerator;

	@Inject
	private TimeTracker thread;

	@Loggable
	public void createBook(String title, String authorName, Float price, String description) {
		thread.startThread();
		book.setCategory(Category.JEE);
		book.setAuthor(author);
		book.setTitle(title);
		book.setPrice(price);
		book.setDescription(description);
		book.setNumber(numberGenerator.generateNumber());
	}
}