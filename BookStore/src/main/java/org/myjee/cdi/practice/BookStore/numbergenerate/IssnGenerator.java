package org.myjee.cdi.practice.BookStore.numbergenerate;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;

public class IssnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Loggable
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISSN-" + issn);
		return issn;
	}

}
