package in.ashokit.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.EducationRequest;
import in.ashokit.bindings.IncomeRequest;
import in.ashokit.bindings.PlanRequest;
import in.ashokit.entity.Education;
import in.ashokit.entity.Income;
import in.ashokit.entity.Kid;
import in.ashokit.entity.Plan;
import in.ashokit.repository.EducationRepository;
import in.ashokit.repository.IncomeRepository;
import in.ashokit.repository.KidRepository;
import in.ashokit.repository.PlanRepository;
import in.ashokit.service.DCService;

@Service
public class DCServiceImpl implements DCService {

	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private IncomeRepository incomeRepo;
	
	@Autowired
	private EducationRepository educationRepo;
	
	@Autowired
	private KidRepository kidRepo;
	@Override
	public String savePlan(PlanRequest pRqst) {
		Plan plan=new Plan();
		if(pRqst!=null) {
			BeanUtils.copyProperties(pRqst, plan);
			Plan savedPlan = planRepo.save(plan);
			if(savedPlan!=null) {
				return "saved";
			}
			return "failed";
		}
		return "invalid";
	}
	@Override
	public String saveIncomeDetails(IncomeRequest iRqst) {
		if(iRqst!=null) {
			Income income=new Income();
			BeanUtils.copyProperties(iRqst, income);
			Income savedIncome = incomeRepo.save(income);
			
				return savedIncome!=null?"saved":"failed";
		}
		
		return "invalid";
	}
	@Override
	public String saveEducationDetails(EducationRequest eRqst) {
		
		if(eRqst!=null) {
			Education education=new Education();
			BeanUtils.copyProperties(eRqst, education);
			Education savedEduction = educationRepo.save(education);
			
				return savedEduction!=null?"saved":"failed";
		}
		
		return "invalid";
	}

	@Override
	public String saveAllKids(List<Kid> kidList) {
		String resp=null;
		System.out.println("KIDS: : >> "+kidList);
		if(kidList!=null) {
			List<Kid> savedKids = kidRepo.saveAll(kidList);
			resp="succeed";
			
		}else {
			resp="failed";
		}
		return resp;
	}
}
