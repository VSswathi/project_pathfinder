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

import com.example.pathfinder.dto.WaterfallTableDto;
import com.example.pathfinder.service.WaterfallService;

@CrossOrigin("*")
@RestController
@RequestMapping("/waterfalltables")
public class WaterfallController {
	
	@Autowired
	WaterfallService waterfallService;

//	26-pathfinder_waterfall_table
	@GetMapping("/waterfall/{totalsavingsmodelbid1}/{totalsavingsmodelaid2}")
	   public ResponseEntity<WaterfallTableDto> waterfall_calc(@PathVariable String totalsavingsmodelbid1,@PathVariable String totalsavingsmodelaid2) {
		WaterfallTableDto input = waterfallService.getByWaterfallId(totalsavingsmodelbid1,totalsavingsmodelaid2);
		return ResponseEntity.ok(input);
	   }
	
	@GetMapping("/waterfall")    
	   public ResponseEntity<List<WaterfallTableDto>> getAllWaterfall() {   
	    List<WaterfallTableDto> inp2 = waterfallService.getAllWaterfall(); 
	 		return new ResponseEntity<List<WaterfallTableDto>>(inp2, HttpStatus.OK);
	 }

}
