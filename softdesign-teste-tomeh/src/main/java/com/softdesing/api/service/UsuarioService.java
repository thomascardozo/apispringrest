package com.softdesing.api.service;

import java.util.List;

import com.softdesing.api.model.Usuario;


public interface UsuarioService {

	List<Usuario> listarTodosUsuarios();
	
	Usuario listarPorIdUsuario(String id);
	
	Usuario cadastrarUsuario(Usuario usuario);
	
	Usuario atualizarUsuario(Usuario usuario);
	
	void removerUsuario(String id);
}
