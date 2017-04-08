package org.myjee.cdi.practice.BookStore.type;

import org.myjee.cdi.practice.BookStore.qualifier.StoreTypeQlfr;
import org.myjee.cdi.practice.BookStore.type.BookStoreType.StoreType;

@StoreTypeQlfr(storeType = StoreType.PAPERBACK)
public class PaperBackStore implements BookStoreType {

	@Override
	public StoreType getType() {
		// TODO Auto-generated method stub
		return StoreType.PAPERBACK;
	}

}
