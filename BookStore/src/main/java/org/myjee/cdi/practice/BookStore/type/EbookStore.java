package org.myjee.cdi.practice.BookStore.type;

import org.myjee.cdi.practice.BookStore.qualifier.StoreTypeQlfr;

@StoreTypeQlfr
public class EbookStore implements BookStoreType {

	@Override
	public StoreType getType() {
		return StoreType.EBOOK;
	}

}
