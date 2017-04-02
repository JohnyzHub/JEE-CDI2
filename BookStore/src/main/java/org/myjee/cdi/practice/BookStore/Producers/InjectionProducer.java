package org.myjee.cdi.practice.BookStore.Producers;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.myjee.cdi.practice.BookStore.interceptor.Loggable;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat;
import org.myjee.cdi.practice.BookStore.qualifier.NumberFormat.DigitFormat;
import org.myjee.cdi.practice.BookStore.qualifier.RandomNumber;
import org.myjee.cdi.practice.plainpojo.time.TimeTracker;

@Loggable
public class InjectionProducer {

	@Produces
	@NumberFormat(value = DigitFormat.THIRTEEN)
	public String prefix13Digits() {
		return "13-";
	}

	@Produces
	@NumberFormat
	public String prefix8Digits() {
		return "8-";
	}

	@Produces
	@NumberFormat(value = DigitFormat.THIRTEEN)
	int number13 = 84356;

	@Produces
	@RandomNumber
	public double random() {
		return Math.abs(new Random().nextInt());
	}

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