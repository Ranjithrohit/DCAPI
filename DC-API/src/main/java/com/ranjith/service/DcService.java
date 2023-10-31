package com.ranjith.service;

import java.util.List;
import java.util.Map;

import com.ranjith.bindings.Child;
import com.ranjith.bindings.ChildRequest;
import com.ranjith.bindings.DcSummary;
import com.ranjith.bindings.Education;
import com.ranjith.bindings.Income;
import com.ranjith.bindings.PlanSelection;

public interface DcService {

	public Long loadCaseNum(Integer appId);
	
	public Map<Integer,String> getPlanNames();
	
	public Long saveplanSelection(PlanSelection planSelection);
	
	public Long saveIncomeDetails(Income income);
	
	public Long saveEducationDtls(Education education);
	
	public Long saveKidsDrtls(ChildRequest childRequest);
	
	public DcSummary getSummary(Long caseNumber);
	
	
}
