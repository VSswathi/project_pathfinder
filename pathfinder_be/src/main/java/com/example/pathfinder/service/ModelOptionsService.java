package com.example.pathfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.helper.ModelOptionsCalc;
import com.example.pathfinder.repo.ItRunSpendRepo;
import com.example.pathfinder.repo.ItSpendOnRunPersonnelRepo;
import com.example.pathfinder.repo.RunOpexModelingFitshoreRepo;
import com.example.pathfinder.repo.SavingsOptimizationRepo;
import com.example.pathfinder.repo.TotalOutsourcingFitshoreRepo;
import com.example.pathfinder.repo.TotalSavingsModel2BRepo;

@Service
public class ModelOptionsService {
	
	@Autowired
	ModelOptionsCalc modelHelp;
	@Autowired
	ItRunSpendRepo runRepo;
	@Autowired
	SavingsOptimizationRepo savingRepo;
	@Autowired
	ItSpendOnRunPersonnelRepo spendRepo;
	@Autowired
	TotalOutsourcingFitshoreRepo fitRepo;
	@Autowired
	TotalSavingsModel2BRepo totalRepo;
	@Autowired
	RunOpexModelingFitshoreRepo opexRepo;

	public TotalSavingsModel2BDto model2b_calculation(String itrunspendid1, String savingoptid2,
			String itspendrunpersid3, String totaloutsourcefitid4) {
		ItRunSpendDto run=runRepo.findById(itrunspendid1).get();
		SavingsOptimizationDto save=savingRepo.findById(savingoptid2).get();
		ItSpendOnRunPersonnelDto spend=spendRepo.findById(itspendrunpersid3).get();
		TotalOutsourcingFitshoreDto fit=fitRepo.findById(totaloutsourcefitid4).get();
		
		
		TotalSavingsModel2BDto obj2=modelHelp.model2bcalculation(run,save, spend,fit);
		obj2= totalRepo.save(obj2);
		return obj2;
	}

	public RunOpexModelingFitshoreDto runfit_calculation(String totalsavingsmodel2bid1) {
		TotalSavingsModel2BDto fit=totalRepo.findById(totalsavingsmodel2bid1).get();		
		RunOpexModelingFitshoreDto obj2=modelHelp.runfit_calculation(fit);
		obj2= opexRepo.save(obj2);
		return obj2;        
	}
	

}
