package org.myjee.cdi.practice.BookStore.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Qualifier
@Target({ TYPE, FIELD, METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberFormat {

	DigitFormat value();

	@Nonbinding
	String description() default "";

	public enum DigitFormat {
		EIGHT, THIRTEEN
	}

}
