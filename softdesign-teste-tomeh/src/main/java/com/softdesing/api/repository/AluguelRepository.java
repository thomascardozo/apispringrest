package com.softdesing.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softdesing.api.model.Aluguel;

public interface AluguelRepository extends MongoRepository<Aluguel, String> {

}
