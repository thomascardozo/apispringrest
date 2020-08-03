package com.softdesing.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.softdesing.api.model.Aluguel;

public interface AluguelRepository extends CrudRepository<Aluguel, String>{
	Aluguel findByCodigo(long codigo);
}
