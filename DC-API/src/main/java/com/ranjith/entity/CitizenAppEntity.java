package com.ranjith.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Entity
@Table(name="CITIZENS_APP")
@Data
public class CitizenAppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	
	private String fullname;
	
	private String email;
	
	private Long phno;
	
	private String gender;
	
	private Long ssn;
	
	private LocalDate dob;
	
	private String stateName;
	
    @CreationTimestamp
	private LocalDate createdDate;
	
    @UpdateTimestamp
	private LocalDate updatedDate;
	
	private String createdBy;
	
	private String updatedBy;

	

	
	
	
	
}
