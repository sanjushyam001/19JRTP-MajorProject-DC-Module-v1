package in.ashokit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.EducationRequest;
import in.ashokit.bindings.IncomeRequest;
import in.ashokit.bindings.PlanRequest;
import in.ashokit.entity.Kid;
import in.ashokit.service.DCService;


@RestController
@RequestMapping("data-collection")
public class DCRestController {

	@Autowired
	private DCService service;
	
	//#1. save selected plan
	
	@PostMapping("/plan-selection")
	public ResponseEntity<?> savePlan(@RequestBody PlanRequest pRqst){
	
		System.out.println("DCRestController.savePlan() PlanRequest Object:  "+pRqst);
		ResponseEntity<?> resp=null;
		String mesg = service.savePlan(pRqst);
		if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("saved")) {
			resp=new ResponseEntity<String>("Plan Selected successfully ..", HttpStatus.CREATED);
		}
		else if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("failed")){
			resp=new ResponseEntity<String>("Plan failed to select ..", HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("Invalid input", HttpStatus.OK);
		}
		return resp;
	}
	//#2. save income details
	
	@PostMapping("/income-details")
	public ResponseEntity<?> saveIncomeDetails(@RequestBody IncomeRequest iRqst){
		
		ResponseEntity<?> resp=null;
		String mesg = service.saveIncomeDetails(iRqst);
		
		if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("saved")) {
			resp=new ResponseEntity<String>("Income details saved successfully ..", HttpStatus.CREATED);
		}
		else if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("failed")){
			resp=new ResponseEntity<String>("Income details failed to save ..", HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("Invalid input", HttpStatus.OK);
		}
		return resp;
		
	}
	//#3. save education details
	
	@PostMapping("/education-details")
	public ResponseEntity<?> saveEductionDetails(@RequestBody EducationRequest eRqst){
		
		ResponseEntity<?> resp=null;
		String mesg = service.saveEducationDetails(eRqst);
		
		if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("saved")) {
			resp=new ResponseEntity<String>("Education details saved successfully ..", HttpStatus.CREATED);
		}
		else if(mesg!=null && !mesg.equalsIgnoreCase("") && mesg.equalsIgnoreCase("failed")){
			resp=new ResponseEntity<String>("Education details failed to save ..", HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("Invalid input", HttpStatus.OK);
		}
		return resp;
		
	}
	
	//#4. save kids details 
	
	@PostMapping("/kids-details")
	public ResponseEntity<?> saveAllKids(@RequestBody List<Kid> kidList){
		ResponseEntity<?> resp=null;
		System.out.println("DCRestController.saveAllKids() KidList: : "+ kidList);
		String mesg = service.saveAllKids(kidList);
		if(mesg!=null && !mesg.equalsIgnoreCase("")&&mesg.equalsIgnoreCase("succeed")) {
			resp=new ResponseEntity<String>("Kids details saved Sucessfully  ",HttpStatus.CREATED);
		}else {
			resp=new ResponseEntity<String>("Failed to saved",HttpStatus.OK);
		}
		return resp;
	}
}
