package com.lucasklauck.orotatto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_horario")
public class Horario {

	@Id
	@GeneratedValue
	@Column(name = "id_horario")
	private Long id;
	
	@Column(name = "tx_nomecliente", nullable = false)
	private String nomeCliente;

	@Column(name = "tx_local", nullable = false)
	private String local;

	@Column(name = "tx_numerotelefone")
	private String numeroTelefone;
	
	@Column(name = "tx_observacoes")
	private String observacoes;
	
	@Column(name = "tx_codigocor")
	private String codigoCor;
	
	@Column(name = "dt_inicio", nullable = false)
	private Date horarioInicio;
	
	@Column(name = "dt_termino")
	private Date horarioTermino;
	
}
