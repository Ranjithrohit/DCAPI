package com.ranjith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.entity.CitizenAppEntity;

public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Integer> {

}
