package org.myjee.cdi.practice.BookStore.booktype;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;
import org.myjee.cdi.practice.BookStore.qualifier.BookFormatQlfr;

@BookFormatQlfr(bookType = BookType.PAPERBACK)
public class PaperBack implements BookFormat {

	@Override
	public BookType getType() {
		// TODO Auto-generated method stub
		return BookType.PAPERBACK;
	}

}
