package org.myjee.cdi.practice.BookStore.booktype;

import org.myjee.cdi.practice.BookStore.qualifier.BookFormatQlfr;

@BookFormatQlfr
public class Ebook implements BookFormat {

	@Override
	public BookType getType() {
		return BookType.EBOOK;
	}

}
