package com.lucasklauck.orotattoagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasklauck.orotattoagenda.model.DataInfo;
import com.lucasklauck.orotattoagenda.service.DataInfoService;

@RestController
@RequestMapping("/data")
public class DataInfoController {
	
	@Autowired
	private DataInfoService dataInfoService;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> salvar(DataInfo dataInfo) {
		
		dataInfoService.salvar(dataInfo);
		
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<DataInfo>> adquirirDatas(){
		
		return ResponseEntity.ok(dataInfoService.adquirirDatas());
	}
}
