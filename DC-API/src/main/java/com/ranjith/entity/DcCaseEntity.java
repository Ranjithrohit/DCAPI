package com.ranjith.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




import lombok.Data;

@Entity
@Table(name = "DC_CASES")
@Data
public class DcCaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long caseNum;
	
	private Integer appId;
	
	private Integer planId;

	public Long getCaseNum() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
