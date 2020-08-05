package com.softdesing.api.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document(collection = "aluguel")
public class Aluguel {
	
	
	@Id
	private String id;
	
	private Book livro;
	private Usuario userAluguel;
	private Date dataInicioAluguel;
	private boolean rented;
	
	public boolean isRented() {
		return rented;
	}
	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	public String getCodigo() {
		return id;
	}
	public void setCodigo(String codigo) {
		this.id = codigo;
	}
	public Book getLivro() {
		return livro;
	}
	public void setLivro(Book livro) {
		this.livro = livro;
	}
	public Usuario getUserAluguel() {
		return userAluguel;
	}
	public void setUserAluguel(Usuario userAluguel) {
		this.userAluguel = userAluguel;
	}
	public Date getDataInicioAluguel() {
		return dataInicioAluguel;
	}
	public void setDataInicioAluguel(Date dataInicioAluguel) {
		this.dataInicioAluguel = dataInicioAluguel;
	}
	
	
	
	
	
}
