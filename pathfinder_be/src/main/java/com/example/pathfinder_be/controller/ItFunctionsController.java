package com.example.pathfinder_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@PostMapping("/input/{inputtableid}/{itpersonelid}")
	   public ResponseEntity<?> itFunctionsCalc(@RequestBody ItFunctionsDto funct,@PathVariable String inputtableid,@PathVariable String itpersonelid ) {
		   ItFunctionsDto input = functionservice.it_functions_calc(funct,inputtableid,itpersonelid);
	       return ResponseEntity.ok(input);
	   }

}
