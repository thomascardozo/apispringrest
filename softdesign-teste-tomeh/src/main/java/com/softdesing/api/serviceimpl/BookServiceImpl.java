package com.softdesing.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesing.api.model.Book;
import com.softdesing.api.repository.BookRepository;
import com.softdesing.api.service.BookService;



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
