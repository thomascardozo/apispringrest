package com.softdesing.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softdesing.api.model.Usuario;
import com.softdesing.api.repository.RoleRepository;
import com.softdesing.api.repository.UsuarioRepository;
import com.softdesing.api.service.UserDetailsImpl;

@Service
@EnableCaching(proxyTargetClass=true)
@EnableAsync(proxyTargetClass=true)
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;	
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
	
	/*public Usuario findUserByEmail(String email) {
	    return userRepository.findByUsername(email);
	}*/

}
