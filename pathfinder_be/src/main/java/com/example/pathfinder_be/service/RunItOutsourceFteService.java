package com.example.pathfinder_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItPersonnelFitModelDto;
import com.example.pathfinder_be.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder_be.dto.RunItOutsourceCostsDto;
import com.example.pathfinder_be.dto.RunItOutsourceFteDto;
import com.example.pathfinder_be.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder_be.helper.RunItOutsourceCalc;
import com.example.pathfinder_be.repo.AssetOutsourceOnsiteRepo;
import com.example.pathfinder_be.repo.CostofTransformationRepo;
import com.example.pathfinder_be.repo.InputTablesRepo;
import com.example.pathfinder_be.repo.ItPersonalCostRepo;
import com.example.pathfinder_be.repo.ItPersonnelFitModelRepo;
import com.example.pathfinder_be.repo.ItSpendOnRunPersonnelRepo;
import com.example.pathfinder_be.repo.ItpersonelRepo;
import com.example.pathfinder_be.repo.RunItOutsourceCostsRepo;
import com.example.pathfinder_be.repo.RunItOutsourceFteRepo;
import com.example.pathfinder_be.repo.TotalOutsourcingFitshoreRepo;

@Service
public class RunItOutsourceFteService {

	@Autowired
	InputTablesRepo inputRepo;
	
	@Autowired
	ItpersonelRepo  itpersonalRepo;
	
	@Autowired
	 ItPersonalCostRepo costRepo;
	@Autowired
	 CostofTransformationRepo cotRepo;
	
	@Autowired
	RunItOutsourceCalc runcalc;
	@Autowired
	 ItSpendOnRunPersonnelRepo itspendRepo;
	
	@Autowired
	RunItOutsourceFteRepo itrunRepo;
	@Autowired
	RunItOutsourceCostsRepo itcostRepo;
	@Autowired
	ItPersonnelFitModelRepo fitRepo;
	@Autowired
	AssetOutsourceOnsiteRepo outsourceonsiteRepo;
	@Autowired
	TotalOutsourcingFitshoreRepo totalRepo;
	
	//14-pathfinder_run_it_outsource_fte
	public RunItOutsourceFteDto runoutsource_calc(String inputtablesid1, String itpersonnelid2,
			String itpersonnelcostid3) {
		InputTablesDto obj=inputRepo.findById(inputtablesid1).get();
        ItPersonnelDto obj1= itpersonalRepo.findById(itpersonnelid2).get();
        ItPersonalCostDto obj2=costRepo.findById(itpersonnelcostid3).get();
        RunItOutsourceFteDto obj3= runcalc.runfteCalc(obj, obj1, obj2);
        obj3=itrunRepo.save(obj3);
        
        return obj3;  
	}

	//15-pathfinder_run_it_outsource_costs
	public RunItOutsourceCostsDto runoutsource_costs_calc(String inputtablesid1, String itpersonnelid2,
			String itpersonnelcostid3, String runitoutsourcefteid4) {
		InputTablesDto obj=inputRepo.findById(inputtablesid1).get();
        ItPersonnelDto obj1= itpersonalRepo.findById(itpersonnelid2).get();
        ItPersonalCostDto obj2=costRepo.findById(itpersonnelcostid3).get();
        RunItOutsourceFteDto obj3= itrunRepo.findById(runitoutsourcefteid4).get();
 
        RunItOutsourceCostsDto obj4= runcalc.runCostsCalc(obj, obj1, obj2,obj3);
        obj4=itcostRepo.save(obj4);
        
        return obj4;
	}


	 //16-pathfinder_itpersonnel_fit_model
	public ItPersonnelFitModelDto fit_model_calc(String inputtablesid1, String itpersonnelcostid2,
			String runitoutsourcefteid3, String runitoutsourcecostsid4) {
		InputTablesDto obj=inputRepo.findById(inputtablesid1).get();
        ItPersonalCostDto obj1=costRepo.findById(itpersonnelcostid2).get();
        RunItOutsourceFteDto obj2= itrunRepo.findById(runitoutsourcefteid3).get();
        RunItOutsourceCostsDto obj3= itcostRepo.findById(runitoutsourcecostsid4).get();
 
        ItPersonnelFitModelDto obj4= runcalc.personnelFitCalc(obj, obj1, obj2,obj3);
        obj4=fitRepo.save(obj4);
        
        return obj4;
	}
	 //17-pathfinder_asset_outsource_onsite
	public AssetOutsourceOnsiteDto outsourceOnsiteCalc(String itpersonnelid1, String costoftransid2,
			String itspendonrunpersonelid3, String runitoutsourcecostsid4) {
		ItPersonnelDto obj=itpersonalRepo.findById(itpersonnelid1).get();
        CostofTransformationDto cot=cotRepo.findById(costoftransid2).get();
        ItSpendOnRunPersonnelDto run= itspendRepo.findById(itspendonrunpersonelid3).get();
        RunItOutsourceCostsDto runit= itcostRepo.findById(runitoutsourcecostsid4).get();
 
        AssetOutsourceOnsiteDto obj4= runcalc.outsourceOnsiteCalc(obj, cot,run,runit);
        obj4=outsourceonsiteRepo.save(obj4);
        
        return obj4;
	}
	 //18-pathfinder_total_outsource_fitshore
	public TotalOutsourcingFitshoreDto outsource_fit_calc(String itpersonnelid1, String costtransformationid2,
			String itpersonnelfitmodelid3, String itspendrunpersonnelid4) {
		
			ItPersonnelDto obj=itpersonalRepo.findById(itpersonnelid1).get();
	        CostofTransformationDto obj1=cotRepo.findById(costtransformationid2).get();
	        ItPersonnelFitModelDto obj2= fitRepo.findById(itpersonnelfitmodelid3).get();
	        ItSpendOnRunPersonnelDto obj3= itspendRepo.findById(itspendrunpersonnelid4).get();
	 
	        TotalOutsourcingFitshoreDto obj4= runcalc.outsourceFitCalc(obj, obj1, obj2,obj3);
	        obj4=totalRepo.save(obj4);
	        
	        return obj4;
	}
}
