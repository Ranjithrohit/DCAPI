package com.ranjith.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.bindings.CreateCaseResponse;
import com.ranjith.service.DcService;

@RestController 
public class CreateCaseController {
	
	@Autowired
	private DcService dcService;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId){
		Long caseNum = dcService.loadCaseNum(appId);
		Map<Integer, String> planMap = dcService.getPlanNames();
		CreateCaseResponse response=new CreateCaseResponse();
		response.setCaseNum(caseNum);
		response.setPlanNames(planMap);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
