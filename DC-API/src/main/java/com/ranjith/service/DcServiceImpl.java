package com.ranjith.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ranjith.bindings.Child;
import com.ranjith.bindings.ChildRequest;
import com.ranjith.bindings.DcSummary;
import com.ranjith.bindings.Education;
import com.ranjith.bindings.Income;
import com.ranjith.bindings.PlanSelection;
import com.ranjith.entity.CitizenAppEntity;
import com.ranjith.entity.DCChildrenEntity;
import com.ranjith.entity.DCEducationEntity;
import com.ranjith.entity.DCIncomeEntity;
import com.ranjith.entity.DcCaseEntity;
import com.ranjith.entity.PlanEntity;
import com.ranjith.repository.CitizenAppRepository;
import com.ranjith.repository.DcCasesRepository;
import com.ranjith.repository.DcChildrenRepository;
import com.ranjith.repository.DcEducationRepository;
import com.ranjith.repository.DcIncomeRepository;
import com.ranjith.repository.PlanRepository;

@Service
public class DcServiceImpl implements DcService {

	private DcCasesRepository dcCasesRepository;
	private PlanRepository planRepository;
	private DcIncomeRepository incomeRepository;
	private DcEducationRepository educationRepository;
	private DcChildrenRepository dcChildrenRepository;
	private CitizenAppRepository appRepository;

	@Override
	public Long loadCaseNum(Integer appId) {
		Optional<CitizenAppEntity> id = appRepository.findById(appId);
		if (id.isPresent()) {
			DcCaseEntity entity = new DcCaseEntity();
			entity.setAppId(appId);
			entity = dcCasesRepository.save(entity);
			return entity.getCaseNum();
		}
		return null;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		List<PlanEntity> findAll = planRepository.findAll();
		Map<Integer,String> plansMap = new HashMap<>();
		for(PlanEntity entity : findAll) {
			plansMap.put(entity.getPlanId(), entity.getPlanName());
		}
		return plansMap;
	}

	@Override
	public Long saveplanSelection(PlanSelection planSelection) {
		Optional<DcCaseEntity> findById = dcCasesRepository.findById(planSelection.getCaseNum());
		if (findById.isPresent()) {
			DcCaseEntity dcCaseEntity = findById.get();
			dcCaseEntity.setPlanId(planSelection.getPlanId());;
			dcCasesRepository.save(dcCaseEntity);
			return planSelection.getCaseNum();
		}
		return null;
	}

	@Override
	public Long saveIncomeDetails(Income income) {
		DCIncomeEntity entity = new DCIncomeEntity();
		BeanUtils.copyProperties(income, entity);
		incomeRepository.save(entity);
		return income.getCaseNum();
	}

	@Override
	public Long saveEducationDtls(Education education) {
		DCEducationEntity educationEntity = new DCEducationEntity();
		BeanUtils.copyProperties(education, educationEntity);
		educationRepository.save(educationEntity);
		return education.getCaseNum();
	}

	@Override
	public Long saveKidsDrtls(ChildRequest childRequest) {
		List<Child> childs = childRequest.getChilds();
		for (Child c : childs) {
			DCChildrenEntity dcChildrenEntity = new DCChildrenEntity();
			BeanUtils.copyProperties(c, dcChildrenEntity);
			dcChildrenRepository.save(dcChildrenEntity);

		}
		return childRequest.getCaseNum();
	}

	@Override
	public DcSummary getSummary(Long caseNumber) {
		
		String planName="";
		DCIncomeEntity incomeEntity = incomeRepository.findByCaseNum(caseNumber);
		DCEducationEntity educationEntity = educationRepository.findByCaseNum(caseNumber);
		List<DCChildrenEntity> childrenEntities = dcChildrenRepository.findByCaseNum(caseNumber);
		Optional<DcCaseEntity> dcCases = dcCasesRepository.findById(caseNumber);
		if(dcCases.isPresent()) {
			Integer planId = dcCases.get().getPlanId();
			Optional<PlanEntity> planRecord = planRepository.findById(planId);
			if(planRecord.isPresent()) {
				planName =  planRecord.get().getPlanName();
			}
		}
		
		DcSummary summary=new DcSummary();
		summary.setPlanName(planName);
		
		Income income=new Income();
		BeanUtils.copyProperties(incomeEntity, income);
		summary.setIncome(income);
		
		Education education=new Education();
		BeanUtils.copyProperties(educationEntity, education);
		summary.setEducation(education);
		
		List<Child> childs = new ArrayList<>();
		for(DCChildrenEntity c : childrenEntities) {
			Child ch=new Child();
			BeanUtils.copyProperties(c, ch);
			childs.add(ch);
		}
        summary.setChilds(childs);
        
		
		
		return summary;
	}

}
