package org.myjee.cdi.practice.BookStore.interceptor;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

	@Inject
	protected Logger logger;

	public Object logMethod(InvocationContext ic) throws Exception {
		logger.info(ic.getTarget() + "::Enter::" + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.info(ic.getTarget().getClass().getName() + "::Exit::" + ic.getMethod().getName());
		}
	}

}