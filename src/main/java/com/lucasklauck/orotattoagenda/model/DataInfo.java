package com.lucasklauck.orotattoagenda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_datainfo")
public class DataInfo {

	@Id
	@GeneratedValue
	@Column(name = "id_data")
	private Long id;
	
	@Column(name = "dt_dia", nullable = false)
	private Date dia;
	
	@Column(name = "tx_codigocor", nullable = false)
	private String codigoCor;	
}
