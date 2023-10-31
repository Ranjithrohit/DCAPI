package com.ranjith.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.DcCaseEntity;

public interface DcCasesRepository extends JpaRepository<DcCaseEntity, Serializable>{
	
	public DcCaseEntity findByAppId(Integer appId);

}
