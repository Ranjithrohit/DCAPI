package com.ranjith.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.DCEducationEntity;

public interface DcEducationRepository extends JpaRepository<DCEducationEntity, Serializable> {
	
	public DCEducationEntity findByCaseNum(Long caseNum);

}
