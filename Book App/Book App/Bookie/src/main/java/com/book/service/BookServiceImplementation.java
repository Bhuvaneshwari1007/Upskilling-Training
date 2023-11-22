package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.BookDetails;
import com.book.repository.BookRepository;
@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookDetails> showAllBookDetails() {
		List<BookDetails> bookDetails = bookRepository.findAll();
		return bookDetails;
	}

	@Override
	public BookDetails showBookById(long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public BookDetails addBook(BookDetails bookDetails) {
			return bookRepository.insert(bookDetails);
		}

	@Override
	public BookDetails updateBook(BookDetails bookDetails) {
		return bookRepository.save(bookDetails);
		}

	@Override
	public String deleteBook(long id) {
		return "Book with the "+id+"Deleted Successfully!";
	}

}
