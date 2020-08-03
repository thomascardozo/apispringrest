package com.softdesing.api.controllers;

import java.util.List;

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

import com.softdesing.api.model.Usuario;
import com.softdesing.api.service.UsuarioService;



@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Retorna a listagem de todos os usuários
	@GetMapping(path = "/usuarios") // pega o mapeamento geral da classe
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(this.usuarioService.listarTodosUsuarios());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable  (name = "id") String id){
		return ResponseEntity.ok(this.usuarioService.listarPorIdUsuario(id));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(this.usuarioService.cadastrarUsuario(usuario));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable(name = "id") String id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return ResponseEntity.ok(this.usuarioService.atualizarUsuario(usuario));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> removerUsuario(@PathVariable (name = "id") String id){
		this.usuarioService.removerUsuario(id);
		return ResponseEntity.ok(1);
	}

}
