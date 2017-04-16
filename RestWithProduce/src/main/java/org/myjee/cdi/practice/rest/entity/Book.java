package org.myjee.cdi.practice.rest.entity;

public interface Book {

	public enum BookType {
		FICTION, SUSPENSE, INVALID
	}

	BookType getType();

}
