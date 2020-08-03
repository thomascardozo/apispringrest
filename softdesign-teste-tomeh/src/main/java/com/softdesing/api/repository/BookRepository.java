package com.softdesing.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softdesing.api.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
