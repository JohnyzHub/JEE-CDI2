package org.myjee.cdi.practice.BookStore.numbergenerate;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat.DigitFormat;
import org.myjee.cdi.practice.BookStore.qualifier.RandomNumber;

@NumberFormat(value = DigitFormat.THIRTEEN, description = "Thirteen Digits")
public class IsbnGenerator extends NumberGenerator {

	@Inject
	private Logger logger;

	@Inject
	@NumberFormat(value = DigitFormat.THIRTEEN)
	private String prefix13Digits;

	@Inject
	@NumberFormat(value = DigitFormat.THIRTEEN)
	private int number13;

	@Inject
	@RandomNumber
	private double randomNumber;

	@Loggable
	public String generateNumber() {
		String isbn = prefix13Digits + number13 + "-" + randomNumber;
		logger.info("Generated ISBN-" + isbn);
		return isbn;
	}
}
