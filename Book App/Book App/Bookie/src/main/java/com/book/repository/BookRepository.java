package com.book.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.model.BookDetails;
@Repository
public interface BookRepository extends MongoRepository<BookDetails, Long> {

}
