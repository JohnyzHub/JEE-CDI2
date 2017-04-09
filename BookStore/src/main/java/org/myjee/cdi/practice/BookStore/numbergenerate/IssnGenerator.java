package org.myjee.cdi.practice.BookStore.numbergenerate;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.RandomNumber;

@NumberFormat
public class IssnGenerator extends NumberGenerator {

	@Inject
	private Logger logger;

	@Inject
	@NumberFormat
	private String prefix8Digits;

	@Inject
	@RandomNumber
	private double randomNumber;

	@Loggable
	public String generateNumber() {
		String issn = prefix8Digits + randomNumber;
		logger.info("Generated ISSN-" + issn);
		return issn;
	}
}