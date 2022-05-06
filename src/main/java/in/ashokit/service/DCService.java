package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.EducationRequest;
import in.ashokit.bindings.IncomeRequest;
import in.ashokit.bindings.PlanRequest;
import in.ashokit.entity.Kid;


public interface DCService {

	public String savePlan(PlanRequest pRqst);
	
	public String saveIncomeDetails(IncomeRequest iRqst);
	
	public String saveEducationDetails(EducationRequest eRqst);
	
	public String saveAllKids(List<Kid> kidList);
}
