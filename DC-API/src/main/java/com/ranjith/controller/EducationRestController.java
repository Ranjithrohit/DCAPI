package com.ranjith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.bindings.Education;
import com.ranjith.service.DcService;

@RestController
public class EducationRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/education")
	public ResponseEntity<Long> saveEducation(@RequestBody Education education){
		Long saveEducationDtls = dcService.saveEducationDtls(education);
		return new ResponseEntity<>(saveEducationDtls, HttpStatus.CREATED);
	}

}
