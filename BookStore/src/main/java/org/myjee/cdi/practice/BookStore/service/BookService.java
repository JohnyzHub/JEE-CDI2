package org.myjee.cdi.practice.BookStore.service;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.Producers.DynamicProducer;
import org.myjee.cdi.practice.BookStore.booktype.BookFormat;
import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;
import org.myjee.cdi.practice.BookStore.entity.Author;
import org.myjee.cdi.practice.BookStore.entity.Book;
import org.myjee.cdi.practice.BookStore.entity.BookPrice;
import org.myjee.cdi.practice.BookStore.entity.Category;
import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.numbergenerate.NumberGenerator;
import org.myjee.cdi.practice.BookStore.qualifier.BookFormatQlfr;
import org.myjee.cdi.practice.BookStore.qualifier.BookPriceQlfr;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat.DigitFormat;
import org.myjee.cdi.practice.plainpojo.time.TimeTracker;

public class BookService {

	@Inject
	private DynamicProducer dynamicProducer;

	@Inject
	@BookFormatQlfr(bookType = BookType.PAPERBACK)
	private BookFormat bookFormat;

	@Inject
	@BookPriceQlfr(BookType.PAPERBACK)
	private BookPrice bookPrice;

	@NumberFormat(value = DigitFormat.THIRTEEN, description = "Thirteen Digits")
	@Inject
	private NumberGenerator numberGenerator;

	@Inject
	private TimeTracker thread;

	@Inject
	private Logger logger;

	@Inject
	private Event<Book> eventNotifier;

	/**
	 * @Inject private StoreDetails storeDetails;
	 */

	@Loggable
	public void createBook(String title, String authorName, Float price, String description) {
		thread.startThread();
		createBookThroughInjectionAndExtention();
		Book book = new Book();
		book.setBookFormat(bookFormat);
		book.setCategory(Category.JEE);
		Author author = dynamicProducer.getAuthor(bookFormat.getType());
		book.setAuthor(author);
		book.setTitle(title);
		book.setPrice(bookPrice);
		book.setDescription(description);
		book.setNumber(numberGenerator.generateNumber());
		logger.info("Sync Event fired: Book");
		eventNotifier.fire(book);
		logger.info("Async Event fired: Book");
		eventNotifier.fireAsync(book);

	}

	/*
	 * This method creates Book with title and description read from
	 * PropertyLoaderExtention. This is not working yet.
	 */

	private void createBookThroughInjectionAndExtention() {
		/**
		 * System.out.println("Store Details: name " + storeDetails.getName() +
		 * " number " + storeDetails.getNumber());
		 */

	}
}