package com.lucasklauck.orotattoagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasklauck.orotattoagenda.model.Horario;
import com.lucasklauck.orotattoagenda.service.HorarioService;

@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.0.104:4200"})
@RequestMapping("horario")
@Controller
public class HorarioController {
	
	@Autowired
	private HorarioService horarioService;
	
	@CrossOrigin
	@GetMapping(path = "adquirir")
	public ResponseEntity<List<Horario>> adquirirHorarios(){
		
		return ResponseEntity.ok(horarioService.adquirirTodos());
	}
	
	@CrossOrigin
	@PostMapping(path = "salvar")
	public ResponseEntity<Horario> salvar(@RequestBody Horario horario ){
		
		return ResponseEntity.ok(horarioService.salvar(horario));
	}
	
	@CrossOrigin
	@DeleteMapping(path = "deletar")
	public ResponseEntity<Void> deletar(@RequestBody Horario horario ){
		
		horarioService.deletar(horario);
		
		return ResponseEntity.ok().build();
	}
	


}
