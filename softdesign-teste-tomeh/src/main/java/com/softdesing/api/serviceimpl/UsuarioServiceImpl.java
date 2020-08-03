package com.softdesing.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesing.api.model.Usuario; 
import com.softdesing.api.repository.UsuarioRepository;
import com.softdesing.api.service.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarTodosUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario listarPorIdUsuario(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);	
		
		return usuario.get();
	}

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void removerUsuario(String id) {
		this.usuarioRepository.deleteById(id); 
	}
}
