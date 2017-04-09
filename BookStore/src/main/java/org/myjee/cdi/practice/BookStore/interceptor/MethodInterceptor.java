package org.myjee.cdi.practice.BookStore.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 100)
public class MethodInterceptor extends LoggingInterceptor {

	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		logger.info("Entering AroundInvoke");
		return super.logMethod(ic);
	}
}
