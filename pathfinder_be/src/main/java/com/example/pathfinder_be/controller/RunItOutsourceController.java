package com.example.pathfinder_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder_be.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder_be.dto.ItPersonnelFitModelDto;
import com.example.pathfinder_be.dto.RunItOutsourceCostsDto;
import com.example.pathfinder_be.dto.RunItOutsourceFteDto;
import com.example.pathfinder_be.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder_be.service.RunItOutsourceFteService;
@CrossOrigin("*")
@RestController
@RequestMapping("/outsource")
public class RunItOutsourceController {

	@Autowired
	RunItOutsourceFteService runitService;
	//14-pathfinder_run_it_outsource_fte
	 @GetMapping("/runpersonnel/{inputtablesid1}/{itpersonnelid2}/{itpersonnelcostid3}")
	    public ResponseEntity<?> runit_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelid2,@PathVariable String itpersonnelcostid3) {
		 RunItOutsourceFteDto input = runitService.runoutsource_calc(inputtablesid1, itpersonnelid2, itpersonnelcostid3);
	        return ResponseEntity.ok(input);
	        
	    }
	 //15-pathfinder_run_it_outsource_costs
	 @GetMapping("/runcosts/{inputtablesid1}/{itpersonnelid2}/{itpersonnelcostid3}/{runitoutsourcefteid4}")
	    public ResponseEntity<?> runcosts_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelid2,@PathVariable String itpersonnelcostid3,@PathVariable String runitoutsourcefteid4) {
		 RunItOutsourceCostsDto input = runitService.runoutsource_costs_calc(inputtablesid1, itpersonnelid2, itpersonnelcostid3,runitoutsourcefteid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 //16-pathfinder_itpersonnel_fit_model
	 @GetMapping("/fitmodel/{inputtablesid1}/{itpersonnelcostid2}/{runitoutsourcefteid3}/{runitoutsourcecostsid4}")
	    public ResponseEntity<?> fitmodel_calc(@PathVariable String inputtablesid1,@PathVariable String itpersonnelcostid2,@PathVariable String runitoutsourcefteid3,@PathVariable String runitoutsourcecostsid4) {
		 ItPersonnelFitModelDto input = runitService.fit_model_calc(inputtablesid1, itpersonnelcostid2,runitoutsourcefteid3,runitoutsourcecostsid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 //17-pathfinder_asset_outsource_onsite
	 @GetMapping("/outsourceonsite/{itpersonnelid1}/{costoftransid2}/{itspendonrunpersonelid3}/{runitoutsourcecostsid4}")
	    public ResponseEntity<?> outsourceonsite_calc(@PathVariable String itpersonnelid1,@PathVariable String costoftransid2,@PathVariable String itspendonrunpersonelid3,@PathVariable String runitoutsourcecostsid4) {
		 AssetOutsourceOnsiteDto input = runitService.outsourceOnsiteCalc(itpersonnelid1, costoftransid2,itspendonrunpersonelid3,runitoutsourcecostsid4);
	        return ResponseEntity.ok(input);
	        
	    }
	 //18-pathfinder_total_outsource_fitshore
	 @GetMapping("/outsourcefit/{itpersonnelid1}/{costtransformationid2}/{itpersonnelfitmodelid3}/{itspendrunpersonnelid4}")
	    public ResponseEntity<?> outsourcefit_calc(@PathVariable String itpersonnelid1,@PathVariable String costtransformationid2,@PathVariable String itpersonnelfitmodelid3,@PathVariable String itspendrunpersonnelid4) {
		 TotalOutsourcingFitshoreDto input = runitService.outsource_fit_calc(itpersonnelid1, costtransformationid2,itpersonnelfitmodelid3,itspendrunpersonnelid4);
	        return ResponseEntity.ok(input);
	        
	    }





}
