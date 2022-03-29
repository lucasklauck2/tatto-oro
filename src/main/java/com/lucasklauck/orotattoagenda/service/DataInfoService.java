package com.lucasklauck.orotattoagenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasklauck.orotattoagenda.model.DataInfo;
import com.lucasklauck.orotattoagenda.repository.DataInfoRepository;

@Service
public class DataInfoService {

	@Autowired
	private DataInfoRepository dataInfoRepository;

	public void salvar(DataInfo dataInfo) {

		if (dataInfo.getId() != null) {
			
			Optional<DataInfo> optDataInfo = dataInfoRepository.findById(dataInfo.getId());

			if (optDataInfo.isEmpty()) {

				DataInfo dataInfoExistente = optDataInfo.get();
				dataInfoExistente.setCodigoCor(dataInfo.getCodigoCor());

				dataInfoRepository.save(dataInfoExistente);
				
				return;
			}
		}

		dataInfoRepository.save(dataInfo);
	}

	public List<DataInfo> adquirirDatas() {

		return dataInfoRepository.findAll();
	}
}
