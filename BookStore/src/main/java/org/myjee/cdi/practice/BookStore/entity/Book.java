/**
 * 
 */
package org.myjee.cdi.practice.BookStore.entity;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.myjee.cdi.practice.BookStore.booktype.BookFormat;

/**
 * @author johnybasha
 *
 */
public class Book {

	@Inject
	private Logger logger;

	private String title;

	private BookFormat bookFormat;

	private BookPrice bookPrice;

	private String description;

	private String number;

	private Author author;

	private Category category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookPrice getPrice() {
		return bookPrice;
	}

	public void setPrice(BookPrice bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BookFormat getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(BookFormat bookFormat) {
		this.bookFormat = bookFormat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", format = " + bookFormat.getType() + ", price=" + bookPrice.getPrice()
				+ ",\n description=" + description + ", number=" + number + "," + author + "]";
	}

	@PostConstruct
	private void init() {
		logger.info("PostConstruct called: " + this);
	}

	@PreDestroy
	private void destroy() {
		logger.info("PreDestroy called: " + this);
	}
}