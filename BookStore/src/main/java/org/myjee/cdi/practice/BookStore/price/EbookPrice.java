package org.myjee.cdi.practice.BookStore.price;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;
import org.myjee.cdi.practice.BookStore.entity.BookPrice;
import org.myjee.cdi.practice.BookStore.qualifier.BookPriceQlfr;

@BookPriceQlfr(value = BookType.EBOOK)
public class EbookPrice implements BookPrice {

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 23.99f;
	}
}
