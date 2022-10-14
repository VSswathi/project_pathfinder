package com.example.pathfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder.dto.SavingsOptimizationDto;
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

}
