package com.example.pathfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.service.ModelOptionsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/model")
public class ModelOptionsController {
	
	@Autowired
	ModelOptionsService modelService;
	
	@GetMapping("/totalmodel2b/{itrunspendid1}/{savingoptid2}/{itspendrunpersid3}/{totaloutsourcefitid4}")
    public ResponseEntity<?> model2b_calculation(@PathVariable String itrunspendid1,@PathVariable String savingoptid2,@PathVariable String itspendrunpersid3,@PathVariable String totaloutsourcefitid4) {
		TotalSavingsModel2BDto input = modelService.model2b_calculation(itrunspendid1, savingoptid2, itspendrunpersid3,totaloutsourcefitid4);
        return ResponseEntity.ok(input);
        
    }
	
	
	@GetMapping("/runfitshore/{totalsavingsmodel2bid1}")
    public ResponseEntity<?> runfit_calculation(@PathVariable String totalsavingsmodel2bid1) {
		RunOpexModelingFitshoreDto input = modelService.runfit_calculation(totalsavingsmodel2bid1);
        return ResponseEntity.ok(input);
        
    }
	

}
