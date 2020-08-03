package com.softdesing.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document(collection = "book")
public class Book {

	@Id
	private String id;
	private String name;
	private String authorName;
	private int qtdPages;
	private int anoBook;
	private String editora;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getQtdPages() {
		return qtdPages;
	}

	public void setQtdPages(int qtdPages) {
		this.qtdPages = qtdPages;
	}

	public int getAnoBook() {
		return anoBook;
	}

	public void setAnoBook(int anoBook) {
		this.anoBook = anoBook;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

}
