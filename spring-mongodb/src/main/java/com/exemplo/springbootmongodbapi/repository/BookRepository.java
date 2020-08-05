package com.exemplo.springbootmongodbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exemplo.springbootmongodbapi.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
