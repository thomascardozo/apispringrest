package com.exemplo.springbootmongodbapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.springbootmongodbapi.model.Book;
import com.exemplo.springbootmongodbapi.repository.BookRepository;
import com.exemplo.springbootmongodbapi.service.BookService;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> listarTodosLivros() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book listarPorIdBook(String id) {
		Optional<Book> livro = bookRepository.findById(id);	
		
		return livro.get();
	}

	@Override
	public Book cadastrarBook(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public Book atualizarBook(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public void removerBook(String id) {
		this.bookRepository.deleteById(id); 
	}


}
