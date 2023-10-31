package com.ranjith.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenAppRequest {

	private String fullname;
	
	private String email;
	
	private Long phno;
	
	private String gender;
	
	private Long ssn;
	
	private LocalDate dob;
}
