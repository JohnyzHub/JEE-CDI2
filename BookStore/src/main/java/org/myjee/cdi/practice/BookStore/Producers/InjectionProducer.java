package org.myjee.cdi.practice.BookStore.Producers;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.plainpojo.time.TimeTracker;

@Loggable
public class InjectionProducer {

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	public TimeTracker produceTimeTracker() {
		return new TimeTracker();
	}

	public void disposeInfiniteThread(@Disposes TimeTracker timeTracker) {
		timeTracker.stopThread();
	}
}