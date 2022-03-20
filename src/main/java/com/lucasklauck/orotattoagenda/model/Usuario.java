package com.lucasklauck.orotattoagenda.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_usuario")
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "tx_usuario", nullable = false)
	private String usuario;
	
	@Column(name = "tx_senha", nullable = false)
	private String senha;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {

		return senha;
	}

	@Override
	public String getUsername() {

		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}
