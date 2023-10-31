package com.ranjith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.bindings.ChildRequest;
import com.ranjith.bindings.DcSummary;
import com.ranjith.service.DcService;

@RestController
public class ChildRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/saveChild")
	public ResponseEntity<DcSummary> saveChild(@RequestBody ChildRequest childRequest){
		Long saveKidsDrtls = dcService.saveKidsDrtls(childRequest);
		DcSummary summary = dcService.getSummary(saveKidsDrtls);
		return new ResponseEntity<>(summary,HttpStatus.OK);
	}
}
