package org.myjee.cdi.practice.rest.entity;

public class SuspenseBook implements Book {

	@Override
	public BookType getType() {
		return BookType.SUSPENSE;
	}
}