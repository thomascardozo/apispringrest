package com.softdesing.api.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softdesing.api.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
  Optional<Usuario> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
