package org.myjee.cdi.practice.rest.selector;

import org.myjee.cdi.practice.rest.entity.Book;
import org.myjee.cdi.practice.rest.entity.Book.BookType;
import org.myjee.cdi.practice.rest.entity.FictionBook;
import org.myjee.cdi.practice.rest.entity.SuspenseBook;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
public class BookSelector {

	@Inject
	private Instance<Book> bookInstance;

	private String type = null;

	private void setType(String type) {
		this.type = type;
	}

	private String getType() {
		return type;
	}

	public BookType getBookType(String type) {
		setType(type);
		for (Book book : bookInstance) {
			return book.getType();
		}
		return BookType.INVALID;
	}

	@Produces
	public Book bookProducer(InjectionPoint point) {
		String type = getType();
		if (type.equalsIgnoreCase(BookType.FICTION.name())) {
			return new FictionBook();
		}

		if (type.equalsIgnoreCase(BookType.SUSPENSE.name())) {
			return new SuspenseBook();
		}

		Book invalid = () -> {
			return BookType.INVALID;
		};
		return invalid;
	}
}