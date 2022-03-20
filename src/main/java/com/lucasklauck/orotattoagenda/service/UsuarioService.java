package com.lucasklauck.orotattoagenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucasklauck.orotattoagenda.model.AlteracaoSenhaDTO;
import com.lucasklauck.orotattoagenda.model.Usuario;
import com.lucasklauck.orotattoagenda.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void alterarSenha(String token, AlteracaoSenhaDTO alteracaoSenhaDTO) {
		
		String usuarioString = JWTTokenAutenticacaoService.extrairUsuarioDeToken(token);
		
		Usuario usuario = usuarioRepository.findByUsuario(usuarioString);
		
		if(usuario == null) {
			
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (passwordEncoder.matches(alteracaoSenhaDTO.getSenhaAntiga(), usuario.getSenha())) {
			
			usuario.setSenha(passwordEncoder.encode(alteracaoSenhaDTO.getSenhaNova()));
			
			usuarioRepository.save(usuario);
		    
		} else {
			
		    throw new BadCredentialsException("Senha incorreta!");
		}
	}
}
