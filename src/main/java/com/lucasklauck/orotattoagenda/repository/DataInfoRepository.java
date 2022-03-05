package com.lucasklauck.orotattoagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasklauck.orotattoagenda.model.DataInfo;

@Repository
public interface DataInfoRepository extends JpaRepository<DataInfo, Long>{
	
}
