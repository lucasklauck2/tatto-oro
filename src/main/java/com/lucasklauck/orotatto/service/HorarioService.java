package com.lucasklauck.orotatto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasklauck.orotatto.model.Horario;
import com.lucasklauck.orotatto.repository.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horarioRepository;

	public List<Horario> adquirirTodos() {
		
		return horarioRepository.findAll();
	}
	
	public Horario salvar(Horario horario) {
		
		return horarioRepository.save(horario);
	}
	
	public void deletar(Horario horario) {
		
		horarioRepository.delete(horario);
	}

}
