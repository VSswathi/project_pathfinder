package com.example.pathfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.RunOpexModellingDto;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.helper.ModelOptionsCalc;
import com.example.pathfinder.repo.AssetOutsourceOnsiteRepo;
import com.example.pathfinder.repo.ItRunSpendRepo;
import com.example.pathfinder.repo.ItSpendOnRunPersonnelRepo;
import com.example.pathfinder.repo.RunOpexModelingFitshoreRepo;
import com.example.pathfinder.repo.RunOpexModellingRepo;
import com.example.pathfinder.repo.SavingsOptimizationRepo;
import com.example.pathfinder.repo.TotalOutsourcingFitshoreRepo;
import com.example.pathfinder.repo.TotalSavingsModel2ARepo;
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
	@Autowired
	RunOpexModellingRepo modelRepo;
	@Autowired
	AssetOutsourceOnsiteRepo assetRepo;
	@Autowired
	TotalSavingsModel2ARepo total2aRepo;

	//20-pathfinder_total_savings_model2b
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

	//21-pathfinder_run_opex_fit_shore
	public RunOpexModelingFitshoreDto runfit_calculation(String totalsavingsmodel2bid1) {
		TotalSavingsModel2BDto fit=totalRepo.findById(totalsavingsmodel2bid1).get();		
		RunOpexModelingFitshoreDto obj2=modelHelp.runfit_calculation(fit);
		obj2= opexRepo.save(obj2);
		return obj2;        
	}

	//21-pathfinder_run_opex_model
	public RunOpexModellingDto runopex_calculation(String runopexfitid1) {
		RunOpexModelingFitshoreDto fit=opexRepo.findById(runopexfitid1).get();		
		RunOpexModellingDto obj2=modelHelp.runopex_calculation(fit);
		obj2= modelRepo.save(obj2);
		return obj2;        
	}

	public TotalSavingsModel2ADto model2a_calculation(String itrunspendid1, String savingoptid2,
			String itspendrunpersid3, String assetoutsourceid4, String totalsavings2bid5) {
		ItRunSpendDto run=runRepo.findById(itrunspendid1).get();
		SavingsOptimizationDto save=savingRepo.findById(savingoptid2).get();
		ItSpendOnRunPersonnelDto spend=spendRepo.findById(itspendrunpersid3).get();
		AssetOutsourceOnsiteDto asset=assetRepo.findById(assetoutsourceid4).get();
		TotalSavingsModel2BDto model=totalRepo.findById(totalsavings2bid5).get();
		
		TotalSavingsModel2ADto obj2=modelHelp.model2a_calculation(run,save, spend,asset,model);
		obj2= total2aRepo.save(obj2);
		return obj2;
	}
	

}
