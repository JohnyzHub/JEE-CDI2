package org.myjee.cdi.practice.BookStore.type;

public interface BookStoreType {
	public enum StoreType {
		EBOOK, PAPERBACK
	}

	StoreType getType();

}
