package com.lucasklauck.orotattoagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasklauck.orotattoagenda.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{
	
}
