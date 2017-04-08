package org.myjee.cdi.practice.BookStore.Producers;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.entity.Author;
import org.myjee.cdi.practice.BookStore.entity.Category;
import org.myjee.cdi.practice.BookStore.qualifier.StoreTypeQlfr;
import org.myjee.cdi.practice.BookStore.type.BookStoreType;
import org.myjee.cdi.practice.BookStore.type.BookStoreType.StoreType;

public class AuthorProducer {

	@Inject
	@StoreTypeQlfr(storeType = StoreType.PAPERBACK)
	private BookStoreType storeType;

	@Produces
	public Author produceAuthor() {
		if (storeType.getType() == StoreType.PAPERBACK) {
			return new Author(Category.JEE.getAuthor());
		}
		return new Author(Category.JAVA.getAuthor());
	}
}