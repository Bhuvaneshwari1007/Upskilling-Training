package com.book.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="books")
public class BookDetails {
	@Id
	private Long bookId;
	private String bookName;
	private String author;
	private String  description;
	
	public BookDetails() {
		super();
	}

	public BookDetails(Long bookId, String bookName, String author, String description) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.description = description;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", description="
				+ description + "]";
	}
	
}
