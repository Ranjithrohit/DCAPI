package com.ranjith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.bindings.Income;
import com.ranjith.service.DcService;

@RestController
public class IncomeRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/saveIncome")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income){
		Long saveIncomeDetails = dcService.saveIncomeDetails(income);
		return new ResponseEntity<>(saveIncomeDetails,HttpStatus.CREATED);
	}
}
