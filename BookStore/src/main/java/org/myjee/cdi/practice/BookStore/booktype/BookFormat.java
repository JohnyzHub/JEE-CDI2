package org.myjee.cdi.practice.BookStore.booktype;

public interface BookFormat {
	public enum BookType {
		EBOOK, PAPERBACK
	}

	BookType getType();

}
