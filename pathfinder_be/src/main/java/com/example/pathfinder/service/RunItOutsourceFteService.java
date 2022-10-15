package com.example.pathfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItPersonnelFitModelDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunItOutsourceCostsDto;
import com.example.pathfinder.dto.RunItOutsourceFteDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.helper.RunItOutsourceCalc;
import com.example.pathfinder.repo.AssetOutsourceOnsiteRepo;
import com.example.pathfinder.repo.CostofTransformationRepo;
import com.example.pathfinder.repo.InputTablesRepo;
import com.example.pathfinder.repo.ItPersonalCostRepo;
import com.example.pathfinder.repo.ItPersonnelFitModelRepo;
import com.example.pathfinder.repo.ItSpendOnRunPersonnelRepo;
import com.example.pathfinder.repo.ItpersonelRepo;
import com.example.pathfinder.repo.RunItOutsourceCostsRepo;
import com.example.pathfinder.repo.RunItOutsourceFteRepo;
import com.example.pathfinder.repo.TotalOutsourcingFitshoreRepo;

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
	
	public List<RunItOutsourceFteDto> getAllRunItOutsource() {
		// TODO Auto-generated method stub
		return itrunRepo.findAll();
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

	public List<RunItOutsourceCostsDto> getAllRunCosts() {
		// TODO Auto-generated method stub
		return itcostRepo.findAll();
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
	
	public List<ItPersonnelFitModelDto> getAllFitModel() {
		// TODO Auto-generated method stub
		return fitRepo.findAll();
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
	
	public List<AssetOutsourceOnsiteDto> getAllOutsourceOnsite() {
		// TODO Auto-generated method stub
		return outsourceonsiteRepo.findAll();
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

	public List<TotalOutsourcingFitshoreDto> getAllOutsourceFit() {
		// TODO Auto-generated method stub
		return totalRepo.findAll();
	}








}
