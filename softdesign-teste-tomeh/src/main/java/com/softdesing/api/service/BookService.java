package com.softdesing.api.service;

import java.util.List;

import com.softdesing.api.model.Book;


public interface BookService {

	List<Book> listarTodosLivros();
	
	Book listarPorIdBook(String id);
	
	Book cadastrarBook(Book book);
	
	Book atualizarBook(Book book);
	
	void removerBook(String id);
}
