package org.myjee.cdi.practice.BookStore;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.myjee.cdi.practice.BookStore.service.BookService;

public class BookOperator {

	public static void main(String[] args) {

		Weld weld = new Weld();
		WeldContainer weldContainer = weld.initialize();
		BookService bookService = weldContainer.select(BookService.class).get();
		bookService.createBook("Beginning Java EE 7", "Antonio", 45.57f, "Excellent book");
		weld.shutdown();
	}
}