package com.gl.ccms.labwk16d04dem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ccms.labwk16d04dem1.model.CCRepDetails;
import com.gl.ccms.labwk16d04dem1.service.CCRepDetailService;


@RestController
@RequestMapping("/ccreps")
public class CustomerCareRepController {
	
	@Autowired
	CCRepDetailService ccRepService;
	
	@GetMapping(value="/allCCReps")
	public List <CCRepDetails> getAllCCReps()
	{
		return ccRepService.getAllCCRepDetails();
	}
	
	@GetMapping(value="/allCCReps/{repId}")
	public CCRepDetails getCCRepDetailsById(@PathVariable int repId)
	{
		return ccRepService.getCCRepById(repId);
	}
	
	@PostMapping(value="/allCCReps")
	public String addCCRepDetails(@RequestBody CCRepDetails ccRepDetails)
	{
		ccRepService.saveCCRepDetail(ccRepDetails);
		return "CCRep Details Added Successfully...";
	}
	
	@PutMapping(value="/allCCReps")
	public String updateCCRepDetails(@RequestBody CCRepDetails ccRepDetails,@RequestParam int id)
	{
		ccRepService.saveCCRepDetail(ccRepDetails);
		return "CCRep Details Updated Successfully...";
	}
	
	@DeleteMapping(value="/allCCReps/{repId}")
	public String deleteCCRepDetailsById(@PathVariable int repId)
	{
		ccRepService.deleteCCRepById(repId);
		return "CCRep Details Deleted Successfully";
	}
	

}
