package org.myjee.cdi.practice.BookStore.decorator;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;
import org.myjee.cdi.practice.BookStore.entity.BookPrice;
import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.qualifier.BookPriceQlfr;

@Decorator
public class PaperBackPriceDecorator implements BookPrice {

	@Inject
	@Delegate
	@BookPriceQlfr(BookType.PAPERBACK)
	private BookPrice bookPrice;

	@Inject
	private Logger logger;

	@Loggable
	@Override
	public float getPrice() {
		float price = bookPrice.getPrice();
		price = (price - (price % 15));
		logger.info(BookType.PAPERBACK + " Price: " + price);
		return price;
	}

}
