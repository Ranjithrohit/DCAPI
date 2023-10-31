package com.ranjith.bindings;

import java.util.List;

import lombok.Data;



@Data
public class DcSummary {
    private String planName;
	private Income income;
	private Education education;
	private List<Child> childs;


}
