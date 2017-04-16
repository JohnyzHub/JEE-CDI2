package org.myjee.cdi.practice.rest.entity;

public class FictionBook implements Book {

	@Override
	public BookType getType() {
		return BookType.FICTION;
	}

}
