package com.example.pathfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItFunctionsDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.dto.WaterfallTableDto;
import com.example.pathfinder.helper.WaterfallCalc;
import com.example.pathfinder.repo.TotalSavingsModel2ARepo;
import com.example.pathfinder.repo.TotalSavingsModel2BRepo;
import com.example.pathfinder.repo.WaterfallRepo;

@Service
public class WaterfallService {

	@Autowired
	TotalSavingsModel2ARepo modelaRepo;
	@Autowired
	TotalSavingsModel2BRepo modelbRepo;
	@Autowired
	WaterfallRepo fallRepo;
	@Autowired
	WaterfallCalc fallHelp;
	
	
//	public WaterfallTableDto waterfall_calc(WaterfallTableDto fall, String totalmodelbid1, String totalmodelaid2) {
//		TotalSavingsModel2BDto obj=modelbRepo.findById(totalmodelbid1).get();
//		TotalSavingsModel2ADto obj1=modelaRepo.findById(totalmodelaid2).get();
//		WaterfallTableDto  obj2=fallHelp.calculateValue(fall,obj,obj1);
//		 obj2=fallRepo.save(obj2);
//	     return obj2;
//	}


	public WaterfallTableDto getByWaterfallId(String totalsavingsmodelbid1, String totalsavingsmodelaid2) {
		TotalSavingsModel2BDto bid1=modelbRepo.findById(totalsavingsmodelbid1).get();
		TotalSavingsModel2ADto aid=modelaRepo.findById(totalsavingsmodelaid2).get();
		WaterfallTableDto  obj2=fallHelp.calculateValue(bid1,aid);
		
		
		
		return fallRepo.save(obj2);
				}

	
}