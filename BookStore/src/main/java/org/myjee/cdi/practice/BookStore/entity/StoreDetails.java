package org.myjee.cdi.practice.BookStore.entity;

import org.myjee.cdi.practice.BookStore.extension.Property;
import org.myjee.cdi.practice.BookStore.extension.PropertyFile;

@PropertyFile("StoreDetails.txt")
public class StoreDetails {

	@Property("name")
	private String name;

	@Property("number")
	private Integer number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "StoreDetails [name=" + name + ", number=" + number + "]";
	}

}
