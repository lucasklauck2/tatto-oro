package com.lucasklauck.orotattoagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasklauck.orotattoagenda.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public abstract Usuario findByUsuario(String usuario);
}
