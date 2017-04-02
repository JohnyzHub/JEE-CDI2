package org.myjee.cdi.practice.BookStore.numbergenerate;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat.DigitFormat;

@NumberFormat(value = DigitFormat.THIRTEEN, description = "Thirteen Digits")
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Loggable
	public String generateNumber() {
		String isbn = "13-13458-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN-" + isbn);
		return isbn;
	}

}
