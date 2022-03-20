package com.lucasklauck.orotattoagenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasklauck.orotattoagenda.model.AlteracaoSenhaDTO;
import com.lucasklauck.orotattoagenda.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@PostMapping("/alterarSenha")
	public ResponseEntity<Void> alterarSenha(@RequestHeader("Authorization") String token,
			@RequestBody AlteracaoSenhaDTO alteracaoSenhaDTO) {

		usuarioService.alterarSenha(token, alteracaoSenhaDTO);

		return ResponseEntity.ok().build();
	}
}
