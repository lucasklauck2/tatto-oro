package com.lucasklauck.orotattoagenda.service;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenAutenticacaoService {

	private static final Long EXPERATION_TOKEN = 86400L;

	public static final String SECRET_KEY = "L$wdhw4541-wwfw2$%#ddd";

	public static final String TOKEN_PREFIX = "Bearer";

	public static final String HEADER_STRING = "Authorization";

	public static void addToken(HttpServletResponse response, String username) throws IOException {

		String jwt = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPERATION_TOKEN))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();

		String token = TOKEN_PREFIX + " " + jwt;

		response.addHeader(HEADER_STRING, token);

		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
	}
	
	public static String extrairUsuarioDeToken(String token) {
		
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody().getSubject();
	}

	public static Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(HEADER_STRING);

		if (token != null) {

			String usuario = extrairUsuarioDeToken(token);
			
			if(usuario != null) {
				
				return new UsernamePasswordAuthenticationToken(usuario, null, emptyList());
			}
		}
		
		return null;
	}

}
