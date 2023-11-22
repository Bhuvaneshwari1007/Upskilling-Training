package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.BookDetails;
import com.book.service.BookServiceImplementation;
import com.book.service.sequenceImpl;
@CrossOrigin()
@RestController
@RequestMapping("/book")
public class BookDetailsController {
	@Autowired
	private BookServiceImplementation service;
	
	@Autowired
	private sequenceImpl seq;

	
@GetMapping("/all")
	public List<BookDetails> showAllBookDetails(){
		List<BookDetails> bookDetails = service.showAllBookDetails();
		return(bookDetails);
	}

@GetMapping("/{id}")
public BookDetails showBookById(@PathVariable("id") long id){
	BookDetails bookDetails = service.showBookById(id);
	return (bookDetails);
}

@PostMapping("/add")
public BookDetails addBook(@RequestBody BookDetails bookDetails) {
	long seqid = seq.getNextSequenceId("book");
	 bookDetails.setBookId(seqid);
	BookDetails book = service.addBook(bookDetails);
	return (book);
}

@PutMapping("/update")
public BookDetails UpdateBook(@RequestBody BookDetails bookDetails) {
	BookDetails book = service.updateBook(bookDetails);
	return (book);
}

@DeleteMapping("/delete")
public String deleteBook(@PathVariable("id")long id) {
	service.deleteBook(id);
	return ("Deleted Successfully");
}

}
