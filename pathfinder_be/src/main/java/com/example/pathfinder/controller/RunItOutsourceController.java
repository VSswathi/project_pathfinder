package com.example.pathfinder.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.ItPersonnelFitModelDto;
import com.example.pathfinder.dto.RunItOutsourceCostsDto;
import com.example.pathfinder.dto.RunItOutsourceFteDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.service.RunItOutsourceFteService;
@CrossOrigin("*")
@RestController
@RequestMapping("/outsource")
public class RunItOutsourceController {

	@Autowired
	RunItOutsourceFteService runitService;
	//14-pathfinder_run_it_outsource_fte
	 @GetMapping("/runfte/{inputtablesid1}/{itpersonnelid2}/{itpersonnelcostid3}")
	    public ResponseEntity<?> runit_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelid2,@PathVariable String itpersonnelcostid3) {
		 RunItOutsourceFteDto input = runitService.runoutsource_calc(inputtablesid1, itpersonnelid2, itpersonnelcostid3);
	        return ResponseEntity.ok(input);
	        
	    }
	 
	 @GetMapping("/runfte")    
	   public ResponseEntity<List<RunItOutsourceFteDto>> getAllRunItOutsource() {   
	    List<RunItOutsourceFteDto> inp2 = runitService.getAllRunItOutsource(); 
	 		return new ResponseEntity<List<RunItOutsourceFteDto>>(inp2, HttpStatus.OK);
	 }
	 //15-pathfinder_run_it_outsource_costs
	 @GetMapping("/runcosts/{inputtablesid1}/{itpersonnelid2}/{itpersonnelcostid3}/{runitoutsourcefteid4}")
	    public ResponseEntity<?> runcosts_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelid2,@PathVariable String itpersonnelcostid3,@PathVariable String runitoutsourcefteid4) {
		 RunItOutsourceCostsDto input = runitService.runoutsource_costs_calc(inputtablesid1, itpersonnelid2, itpersonnelcostid3,runitoutsourcefteid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 
	 @GetMapping("/runcosts")    
	   public ResponseEntity<List<RunItOutsourceCostsDto>> getAllRunCosts() {   
	    List<RunItOutsourceCostsDto> inp2 = runitService.getAllRunCosts(); 
	 		return new ResponseEntity<List<RunItOutsourceCostsDto>>(inp2, HttpStatus.OK);
	 }
	 //16-pathfinder_itpersonnel_fit_model
	 @GetMapping("/fitmodel/{inputtablesid1}/{itpersonnelcostid2}/{runitoutsourcefteid3}/{runitoutsourcecostsid4}")
	    public ResponseEntity<?> fitmodel_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelcostid2,@PathVariable String runitoutsourcefteid3,@PathVariable String runitoutsourcecostsid4) {
		 ItPersonnelFitModelDto input = runitService.fit_model_calc(inputtablesid1, itpersonnelcostid2,runitoutsourcefteid3,runitoutsourcecostsid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 
	 @GetMapping("/fitmodel")    
	   public ResponseEntity<List<ItPersonnelFitModelDto>> getAllFitModel() {   
	    List<ItPersonnelFitModelDto> inp2 = runitService.getAllFitModel(); 
	 		return new ResponseEntity<List<ItPersonnelFitModelDto>>(inp2, HttpStatus.OK);
	 }
	 //17-pathfinder_asset_outsource_onsite
	 @GetMapping("/outsourceonsite/{itpersonnelid1}/{costoftransid2}/{itspendonrunpersonelid3}/{runitoutsourcecostsid4}")
	    public ResponseEntity<?> outsourceonsite_calc(@PathVariable String itpersonnelid1,@PathVariable String costoftransid2,@PathVariable String itspendonrunpersonelid3,@PathVariable String runitoutsourcecostsid4) {
		 AssetOutsourceOnsiteDto input = runitService.outsourceOnsiteCalc(itpersonnelid1, costoftransid2,itspendonrunpersonelid3,runitoutsourcecostsid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 
	 @GetMapping("/outsourceonsite")    
	   public ResponseEntity<List<AssetOutsourceOnsiteDto>> getAllOutsourceOnsite() {   
	    List<AssetOutsourceOnsiteDto> inp2 = runitService.getAllOutsourceOnsite(); 
	 		return new ResponseEntity<List<AssetOutsourceOnsiteDto>>(inp2, HttpStatus.OK);
	 }
	 //18-pathfinder_total_outsource_fitshore
	 @GetMapping("/outsourcefit/{itpersonnelid1}/{costtransformationid2}/{itpersonnelfitmodelid3}/{itspendrunpersonnelid4}")
	    public ResponseEntity<?> outsourcefit_calc(@PathVariable String itpersonnelid1,@PathVariable String costtransformationid2,@PathVariable String itpersonnelfitmodelid3,@PathVariable String itspendrunpersonnelid4) {
		 TotalOutsourcingFitshoreDto input = runitService.outsource_fit_calc(itpersonnelid1, costtransformationid2,itpersonnelfitmodelid3,itspendrunpersonnelid4);
	        return ResponseEntity.ok(input);
	        
	    }

	 @GetMapping("/outsourcefit")    
	   public ResponseEntity<List<TotalOutsourcingFitshoreDto>> getAllOutsourceFit() {   
	    List<TotalOutsourcingFitshoreDto> inp2 = runitService.getAllOutsourceFit(); 
	 		return new ResponseEntity<List<TotalOutsourcingFitshoreDto>>(inp2, HttpStatus.OK);
	 }




}
