package com.example.pathfinder_be.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItFunctionsDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.helper.ItFunctionsCalc;
import com.example.pathfinder_be.repo.InputTablesRepo;
import com.example.pathfinder_be.repo.ItFunctionsRepo;
import com.example.pathfinder_be.repo.ItpersonelRepo;

@Service
public class ItFunctionsService {
	@Autowired
	InputTablesRepo inputRepo;

  @Autowired
  ItpersonelRepo itpersonalRepo;
  @Autowired
  ItFunctionsRepo functionRepo;
  @Autowired
  ItFunctionsCalc helpcalc;

	//19-pathfinder_it_functions
	public ItFunctionsDto it_functions_calc(ItFunctionsDto funct, String inputtableid, String itpersonelid) {
		InputTablesDto obj=inputRepo.findById(inputtableid).get();
		ItPersonnelDto obj1=itpersonalRepo.findById(itpersonelid).get();
		ItFunctionsDto  obj2=helpcalc.calculateValue(funct,obj,obj1);
		 obj2=functionRepo.save(obj2);
	     return obj2;
	}


	public Optional<ItFunctionsDto> getByItFunctionsId(String itfunctionid) {
	
		return functionRepo.findById(itfunctionid);
	}
}
