package com.ranjith.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.bindings.PlanSelection;
import com.ranjith.service.DcService;

@RestController
public class PlanSelectionRestController {
	
	private DcService dcService;

	@PostMapping("/planSelection")
	public ResponseEntity<Long> savePlan(@RequestBody PlanSelection planSelection){
		Long caseNum = dcService.saveplanSelection(planSelection);
		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}
	
	

}
