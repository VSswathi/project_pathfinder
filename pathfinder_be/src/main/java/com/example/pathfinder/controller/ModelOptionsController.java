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

import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.RunOpexModelingOutsourceDto;
import com.example.pathfinder.dto.RunOpexModelling2ADto;
import com.example.pathfinder.dto.RunOpexModellingDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
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
	
	@GetMapping("/totalmodel2b")    
	   public ResponseEntity<List<TotalSavingsModel2BDto>> getAllTotalModel2b() {   
	    List<TotalSavingsModel2BDto> inp2 = modelService.getAllTotalModel2b(); 
	 		return new ResponseEntity<List<TotalSavingsModel2BDto>>(inp2, HttpStatus.OK);
	 }
	
	//21-pathfinder_run_opex_fit_shore
	@GetMapping("/runfitshore/{totalsavingsmodel2bid1}")
    public ResponseEntity<?> runfit_calculation(@PathVariable String totalsavingsmodel2bid1) {
		RunOpexModelingFitshoreDto input = modelService.runfit_calculation(totalsavingsmodel2bid1);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/runfitshore")    
	   public ResponseEntity<List<RunOpexModelingFitshoreDto>> getAllRunFit() {   
	    List<RunOpexModelingFitshoreDto> inp2 = modelService.getAllRunFit(); 
	 		return new ResponseEntity<List<RunOpexModelingFitshoreDto>>(inp2, HttpStatus.OK);
	 }
	//22-pathfinder_run_opex_model
	@GetMapping("/runopex/{runopexfitid1}")
    public ResponseEntity<?> runopex_calculation(@PathVariable String runopexfitid1) {
		RunOpexModellingDto input = modelService.runopex_calculation(runopexfitid1);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/runopex")    
	   public ResponseEntity<List<RunOpexModellingDto>> getAllRunOpex() {   
	    List<RunOpexModellingDto> inp2 = modelService.getAllRunOpex(); 
	 		return new ResponseEntity<List<RunOpexModellingDto>>(inp2, HttpStatus.OK);
	 }
	//23-pathfinder_total_savings_model2a
	@GetMapping("/totalmodel2a/{itrunspendid1}/{savingoptid2}/{itspendrunpersid3}/{assetoutsourceid4}/{totalsavings2bid5}")
    public ResponseEntity<?> model2a_calculation(@PathVariable String itrunspendid1,@PathVariable String savingoptid2,@PathVariable String itspendrunpersid3,@PathVariable String assetoutsourceid4,@PathVariable String totalsavings2bid5) {
		TotalSavingsModel2ADto input = modelService.model2a_calculation(itrunspendid1, savingoptid2, itspendrunpersid3,assetoutsourceid4,totalsavings2bid5);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/totalmodel2a")    
	   public ResponseEntity<List<TotalSavingsModel2ADto>> getAllModel2a() {   
	    List<TotalSavingsModel2ADto> inp2 = modelService.getAllModel2a(); 
	 		return new ResponseEntity<List<TotalSavingsModel2ADto>>(inp2, HttpStatus.OK);
	 }
	//24-pathfinder_run_opex_outsource
	@GetMapping("/runoutsource/{totalsavingsmodel2aid1}/{totalsavingsmodel2bid2}")
    public ResponseEntity<?> runoutsource_calculation(@PathVariable String totalsavingsmodel2aid1,@PathVariable String totalsavingsmodel2bid2) {
		RunOpexModelingOutsourceDto input = modelService.runoutsource_calculation(totalsavingsmodel2aid1,totalsavingsmodel2bid2);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/runoutsource")    
	   public ResponseEntity<List<RunOpexModelingOutsourceDto>> getAllRunOutsource() {   
	    List<RunOpexModelingOutsourceDto> inp2 = modelService.getAllRunOutsource(); 
	 		return new ResponseEntity<List<RunOpexModelingOutsourceDto>>(inp2, HttpStatus.OK);
	 }
	
	//25-pathfinder_run_opex_model2a
	@GetMapping("/runopex2a/{runopexoutsourceid1}")
    public ResponseEntity<?> runopex2a_calculation(@PathVariable String runopexoutsourceid1) {
		RunOpexModelling2ADto input = modelService.runopex2a_calculation(runopexoutsourceid1);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/runopex2a")    
	   public ResponseEntity<List<RunOpexModelling2ADto>> getAllRunOpex2a() {   
	    List<RunOpexModelling2ADto> inp2 = modelService.getAllRunOpex2a(); 
	 		return new ResponseEntity<List<RunOpexModelling2ADto>>(inp2, HttpStatus.OK);
	 }
}
