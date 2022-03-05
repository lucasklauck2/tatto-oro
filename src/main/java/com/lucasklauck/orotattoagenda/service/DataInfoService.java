package com.lucasklauck.orotattoagenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasklauck.orotattoagenda.model.DataInfo;
import com.lucasklauck.orotattoagenda.repository.DataInfoRepository;

@Service
public class DataInfoService {

	@Autowired
	private DataInfoRepository dataInfoRepository;

	public void salvar(DataInfo dataInfo) {
		
		dataInfoRepository.save(dataInfo);
	}
	
	public List<DataInfo> adquirirDatas() {
		
		return dataInfoRepository.findAll();
	}
}
