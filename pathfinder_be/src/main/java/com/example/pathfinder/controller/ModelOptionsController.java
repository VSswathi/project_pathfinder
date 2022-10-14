package com.example.pathfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.RunOpexModellingDto;
import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.service.ModelOptionsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/model")
public class ModelOptionsController {
	
	@Autowired
	ModelOptionsService modelService;
	
	//20-pathfinder_total_savings_model2b
	
	@GetMapping("/totalmodel2b/{itrunspendid1}/{savingoptid2}/{itspendrunpersid3}/{totaloutsourcefitid4}")
    public ResponseEntity<?> model2b_calculation(@PathVariable String itrunspendid1,@PathVariable String savingoptid2,@PathVariable String itspendrunpersid3,@PathVariable String totaloutsourcefitid4) {
		TotalSavingsModel2BDto input = modelService.model2b_calculation(itrunspendid1, savingoptid2, itspendrunpersid3,totaloutsourcefitid4);
        return ResponseEntity.ok(input);
        
    }
	
	//21-pathfinder_run_opex_fit_shore
	@GetMapping("/runfitshore/{totalsavingsmodel2bid1}")
    public ResponseEntity<?> runfit_calculation(@PathVariable String totalsavingsmodel2bid1) {
		RunOpexModelingFitshoreDto input = modelService.runfit_calculation(totalsavingsmodel2bid1);
        return ResponseEntity.ok(input);
        
    }
	
	//21-pathfinder_run_opex_model
	@GetMapping("/runopex/{runopexfitid1}")
    public ResponseEntity<?> runopex_calculation(@PathVariable String runopexfitid1) {
		RunOpexModellingDto input = modelService.runopex_calculation(runopexfitid1);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/totalmodel2a/{itrunspendid1}/{savingoptid2}/{itspendrunpersid3}/{assetoutsourceid4}/{totalsavings2bid5}")
    public ResponseEntity<?> model2a_calculation(@PathVariable String itrunspendid1,@PathVariable String savingoptid2,@PathVariable String itspendrunpersid3,@PathVariable String assetoutsourceid4,@PathVariable String totalsavings2bid5) {
		TotalSavingsModel2ADto input = modelService.model2a_calculation(itrunspendid1, savingoptid2, itspendrunpersid3,assetoutsourceid4,totalsavings2bid5);
        return ResponseEntity.ok(input);
        
    }
	

}
