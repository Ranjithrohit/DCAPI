package com.ranjith.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.DCChildrenEntity;

public interface DcChildrenRepository extends JpaRepository<DCChildrenEntity, Serializable> {

	public List<DCChildrenEntity> findByCaseNum(Long caseNum);
}
