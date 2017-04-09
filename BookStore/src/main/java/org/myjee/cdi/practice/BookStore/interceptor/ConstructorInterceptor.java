package org.myjee.cdi.practice.BookStore.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 50)
public class ConstructorInterceptor extends LoggingInterceptor {

	@AroundConstruct
	private void init(InvocationContext ic) throws Exception {
		logger.info("Entering AroundConstruct");
		super.logMethod(ic);
	}
}
