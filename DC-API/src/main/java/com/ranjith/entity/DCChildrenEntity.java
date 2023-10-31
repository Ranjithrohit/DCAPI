package com.ranjith.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name = "DC_CHILDREN")
@Data
public class DCChildrenEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childrenId;
	
	private Long caseNum;
	
	private LocalDate childrenDob;
	
	private Long childrenSsn;
	

	

}
