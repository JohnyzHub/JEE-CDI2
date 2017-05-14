package org.myjee.cdi.practice.BookStore.Producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;
import org.myjee.cdi.practice.BookStore.entity.Author;
import org.myjee.cdi.practice.BookStore.entity.Category;

@ApplicationScoped
public class DynamicProducer {

	@Inject
	private Instance<Author> author;

	private BookType bookType;

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Author getAuthor(BookType bookType) {
		this.bookType = bookType;
		for (Author selectedAuthor : author) {
			return selectedAuthor;
		}
		return null;
	}

	@Produces
	public Author produceAuthor() {
		if (this.bookType == BookType.PAPERBACK) {
			return new Author(Category.JEE.getAuthor());
		} else if (this.bookType == BookType.EBOOK) {
			return new Author(Category.JAVA.getAuthor());
		}
		return null;
	}
}