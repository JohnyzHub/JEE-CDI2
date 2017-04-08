package org.myjee.cdi.practice.BookStore.entity;

public enum Category {

	JAVA("Java Author"), PYTHON("Python Author"), JEE("Antony Goncalves"), SCALA("Scala Author");

	private String author;

	Category(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

}
