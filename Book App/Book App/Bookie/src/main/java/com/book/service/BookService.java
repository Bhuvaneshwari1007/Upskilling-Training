package com.book.service;

import java.util.List;

import com.book.model.BookDetails;

public interface BookService {
	public List<BookDetails> showAllBookDetails();
	public BookDetails showBookById(long id);
	public BookDetails addBook(BookDetails bookDetails);
	public BookDetails updateBook(BookDetails bookDetails);
	public String deleteBook(long id);


}
