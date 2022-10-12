package com.example.pathfinder_be.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder_be.dto.ItFunctionsDto;
import com.example.pathfinder_be.service.ItFunctionsService;
@CrossOrigin("*")
@RestController
@RequestMapping("/itfunctions")
public class ItFunctionsController {
	@Autowired
	ItFunctionsService functionservice;
	
	//19-pathfinder_it_functions
	@PostMapping("/input/{inputtableid}/{itpersonelid}")
	   public ResponseEntity<?> itFunctionsCalc(@RequestBody ItFunctionsDto funct,@PathVariable String inputtableid,@PathVariable String itpersonelid ) {
		   ItFunctionsDto input = functionservice.it_functions_calc(funct,inputtableid,itpersonelid);
	       return ResponseEntity.ok(input);
	   }

	@GetMapping("/getitfunctioninput/{itfunctionid}")    
	   public ResponseEntity<ItFunctionsDto> getByItFunctionsId(@PathVariable String itfunctionid) {   
	    Optional<ItFunctionsDto> inp2 = functionservice.getByItFunctionsId(itfunctionid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
}
