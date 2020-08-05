package com.exemplo.springbootmongodbapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.springbootmongodbapi.model.Book;
import com.exemplo.springbootmongodbapi.service.BookService;

@RestController
@RequestMapping(path = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	// Retorna a listagem de todos os livros
	@GetMapping(path = "/findAllBooks") 
	public ResponseEntity<List<Book>> listarBooks() {
		return ResponseEntity.ok(this.bookService.listarTodosLivros());
	}

	// Retorna um livro por id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Book> listarPorId(@PathVariable  (name = "id") String id){
		return ResponseEntity.ok(this.bookService.listarPorIdBook(id));
	}

	@PostMapping
	public ResponseEntity<Book> cadastrarBook(@RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.cadastrarBook(book));
	}
	
	//Atualiza livro por id
	@PutMapping(path = "/{id}")
	public ResponseEntity<Book> atualizarBook(@PathVariable(name = "id") String id, @RequestBody Book book) {
		book.setId(id);
		return ResponseEntity.ok(this.bookService.atualizarBook(book));
	}


	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> removerBook(@PathVariable (name = "id") String id){
		this.bookService.removerBook(id);
		return ResponseEntity.ok(1);
	}

}
