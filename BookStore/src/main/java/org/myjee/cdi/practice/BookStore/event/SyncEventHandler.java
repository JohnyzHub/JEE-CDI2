package org.myjee.cdi.practice.BookStore.event;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.entity.Book;

public class SyncEventHandler {

	@Inject
	private Logger logger;

	public void notifyBookSync(@Observes Book book) {
		logger.info("Sync Event : " + book);
	}
}
