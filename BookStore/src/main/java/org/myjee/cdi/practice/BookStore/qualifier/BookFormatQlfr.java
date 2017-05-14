package org.myjee.cdi.practice.BookStore.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat.BookType;

@Qualifier
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface BookFormatQlfr {
	BookType bookType() default BookType.EBOOK;

}
