package com.example.pathfinder.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItFunctionsDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.helper.ItFunctionsCalc;
import com.example.pathfinder.repo.InputTablesRepo;
import com.example.pathfinder.repo.ItFunctionsRepo;
import com.example.pathfinder.repo.ItpersonelRepo;

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


	public ItFunctionsDto updateItFunctions(ItFunctionsDto funct, String itfunctionid, String inputtableid,
			String itpersonelid) {
		ItFunctionsDto old2=functionRepo.findById(itfunctionid).get();
		InputTablesDto inp=inputRepo.findById(inputtableid).get();
		ItPersonnelDto itp=itpersonalRepo.findById(itpersonelid).get();
		old2.setData_center_itspend_run_perc(funct.getData_center_itspend_run_perc());
		old2.setEnd_user_computing_itspend_run_perc(funct.getEnd_user_computing_itspend_run_perc());
		old2.setIt_service_desk_itspend_run_perc(funct.getIt_service_desk_itspend_run_perc());
		old2.setNetwork_itspend_run_perc(funct.getNetwork_itspend_run_perc());
		old2.setApplication_enhance_itspend_run_perc(funct.getApplication_enhance_itspend_run_perc());
		old2.setApplication_support_itspend_run_perc(funct.getApplication_support_itspend_run_perc());
		old2.setIt_management_itspend_run_perc(funct.getIt_management_itspend_run_perc());
		old2.setData_center_fte_spread_perc(funct.getData_center_fte_spread_perc());
		old2.setEnd_user_computing_fte_spread_perc(funct.getEnd_user_computing_fte_spread_perc());
		old2.setIt_service_desk_fte_spread_perc(funct.getIt_service_desk_fte_spread_perc());
		old2.setNetwork_fte_spread_perc(funct.getNetwork_fte_spread_perc());
		old2.setApplication_enhance_fte_spread_perc(funct.getApplication_enhance_fte_spread_perc());
		old2.setApplication_support_fte_spread_perc(funct.getApplication_support_fte_spread_perc());
		old2.setIt_management_fte_spread_perc(funct.getIt_management_fte_spread_perc());
		ItFunctionsDto  obj2=helpcalc.calculateValue(old2,inp,itp);
		return functionRepo.save(obj2);
	}
	
	public List<ItFunctionsDto> getAllItFunctions() {
		return functionRepo.findAll();
	}
}
