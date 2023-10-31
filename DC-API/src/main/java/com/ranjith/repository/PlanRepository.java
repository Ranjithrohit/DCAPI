package com.ranjith.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {
	
	public List<String> getPlanNames();

}
