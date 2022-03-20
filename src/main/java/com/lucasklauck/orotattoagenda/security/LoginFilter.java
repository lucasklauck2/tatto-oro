package com.lucasklauck.orotattoagenda.security;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasklauck.orotattoagenda.model.UsuarioDTO;
import com.lucasklauck.orotattoagenda.service.JWTTokenAutenticacaoService;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));

		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		UsuarioDTO usuarioDTO = new ObjectMapper().readValue(request.getInputStream(), UsuarioDTO.class);

		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(usuarioDTO.getUsuario(), usuarioDTO.getSenha(), emptyList()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		JWTTokenAutenticacaoService.addToken(response, authResult.getName());
	}

}
