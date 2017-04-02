package org.myjee.cdi.practice.BookStore.Producers;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.plainpojo.plainpjo_author.Author;
import org.myjee.cdi.practice.plainpojo.plainpjo_author.InfiniteThread;

@Loggable
public class InjectionProducer {

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	public Author produceAuthor() {
		return new Author();
	}

	@Produces
	public InfiniteThread produceInfiniteThread() {
		return new InfiniteThread();
	}

	public void disposeInfiniteThread(@Disposes InfiniteThread infiniteThread) {
		infiniteThread.stopThread();
	}
}