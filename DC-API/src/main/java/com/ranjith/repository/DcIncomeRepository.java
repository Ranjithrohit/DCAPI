package com.ranjith.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.DCIncomeEntity;

public interface DcIncomeRepository extends JpaRepository<DCIncomeEntity, Serializable>{
	
	public DCIncomeEntity findByCaseNum(Long caseNum);

}
