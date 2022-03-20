package com.lucasklauck.orotattoagenda.security;

import static com.lucasklauck.orotattoagenda.service.JWTTokenAutenticacaoService.HEADER_STRING;
import static com.lucasklauck.orotattoagenda.service.JWTTokenAutenticacaoService.SECRET_KEY;
import static com.lucasklauck.orotattoagenda.service.JWTTokenAutenticacaoService.TOKEN_PREFIX;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.lucasklauck.orotattoagenda.service.JWTTokenAutenticacaoService;

import io.jsonwebtoken.Jwts;

public class AuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse responseDois = (HttpServletResponse) response;
		
		Authentication authentication = null;
		
		try {
			authentication = JWTTokenAutenticacaoService.getAuthentication((HttpServletRequest) request);
		} catch (Exception e) {
			responseDois.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		if (!tokenValido((HttpServletRequest) request)) {

			responseDois.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(request, response);

	}

	private boolean tokenValido(HttpServletRequest request) {

		String token = request.getHeader(HEADER_STRING);

		if (token == null) {
			return false;
		}

		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
