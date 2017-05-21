package org.myjee.cdi.practice.BookStore.event;

import java.util.logging.Logger;

import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.entity.Book;

public class AsyncEventHandler {

	@Inject
	private Logger logger;

	public void notifyBookAsync(@ObservesAsync Book book) {
		logger.info("Async Event : " + book);
	}
}
