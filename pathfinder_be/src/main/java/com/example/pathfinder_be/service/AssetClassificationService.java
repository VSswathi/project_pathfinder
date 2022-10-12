package com.example.pathfinder_be.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.AssetClassificationDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder_be.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder_be.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder_be.dto.SavingsOptimizationDto;
import com.example.pathfinder_be.helper.AssetClassificationCalc;
import com.example.pathfinder_be.repo.AssetClassificationHardwareRepo;
import com.example.pathfinder_be.repo.AssetClassificationHostedCbsRepo;
import com.example.pathfinder_be.repo.AssetClassificationManagedServicesRepo;
import com.example.pathfinder_be.repo.AssetClassificationRepo;
import com.example.pathfinder_be.repo.AssetClassificationSoftwareRepo;
import com.example.pathfinder_be.repo.CostofTransformationRepo;
import com.example.pathfinder_be.repo.InputTablesRepo;
import com.example.pathfinder_be.repo.ItRunSpendRepo;
import com.example.pathfinder_be.repo.ItSpendCategoriesRepo;
import com.example.pathfinder_be.repo.ItSpendOnRunPersonnelRepo;
import com.example.pathfinder_be.repo.ItpersonelRepo;
import com.example.pathfinder_be.repo.SavingsOptimizationRepo;

@Service
public class AssetClassificationService {

	@Autowired
	InputTablesRepo inputRepo;
	
	@Autowired
	AssetClassificationCalc help;
	
	@Autowired
	CostofTransformationRepo cotRepo;
	
	@Autowired
	ItpersonelRepo  itpersonalRepo;
	@Autowired
	AssetClassificationRepo assetRepo;
	
	@Autowired
	ItSpendCategoriesRepo spendRepo;
	
	@Autowired
	ItRunSpendRepo runRepo;
	@Autowired
	ItSpendOnRunPersonnelRepo itrunRepo;
	@Autowired
	AssetClassificationHardwareRepo hardRepo;
	@Autowired
	AssetClassificationSoftwareRepo softRepo;
	@Autowired
	AssetClassificationManagedServicesRepo managedRepo;
	@Autowired
	AssetClassificationHostedCbsRepo hostedRepo;
	@Autowired
	SavingsOptimizationRepo savingRepo;
	


//7-pathfinder_asset_classification_hardware
	public AssetClassificationHardwareDto hardware_calculation(AssetClassificationHardwareDto h,
			String itrunspendid2, String inputtablesid3, String itspendcategoriesid4) {
			
		ItRunSpendDto run=runRepo.findById(itrunspendid2).get();
		InputTablesDto inp=inputRepo.findById(inputtablesid3).get();
		ItSpendCategoriesDto isc=spendRepo.findById(itspendcategoriesid4).get();
        
        AssetClassificationHardwareDto obj3= help.hardwareCalculation(h, run, inp, isc);
       
        obj3=hardRepo.save(obj3);
        return obj3;   
	}
	
	public Optional<AssetClassificationHardwareDto> getByHardwareId(String hardwareid) {
		// TODO Auto-generated method stub
		return hardRepo.findById(hardwareid);
	}
	
	
	//8-pathfinder_asset_classification_software
	public AssetClassificationSoftwareDto software_calculation(AssetClassificationSoftwareDto s,
			String itrunspendid2, String inputtablesid3, String itspendcategoriesid4) {
		
		ItRunSpendDto run=runRepo.findById(itrunspendid2).get();
		InputTablesDto inp=inputRepo.findById(inputtablesid3).get();
		ItSpendCategoriesDto isc=spendRepo.findById(itspendcategoriesid4).get();
        
        AssetClassificationSoftwareDto obj3= help.softwareCalculation(s, run, inp, isc);
       
        obj3=softRepo.save(obj3);
        return obj3;   
	}
	
	public Optional<AssetClassificationSoftwareDto> getBySoftwareId(String softwareid) {
	
		return softRepo.findById(softwareid);
	}

	//9-pathfinder_asset_classification_managed
	public AssetClassificationManagedServicesDto managed_calculation(AssetClassificationManagedServicesDto m,
    String itrunspendid1, String inputtablesid2, String itspendcategoriesid3) {
		
		ItRunSpendDto run=runRepo.findById(itrunspendid1).get();
		InputTablesDto inp=inputRepo.findById(inputtablesid2).get();
		ItSpendCategoriesDto isc=spendRepo.findById(itspendcategoriesid3).get();
		
		AssetClassificationManagedServicesDto obj3= help.managedCalculation(m, run, inp, isc);
		
		obj3=managedRepo.save(obj3);
		return obj3;
	}
	
	public Optional<AssetClassificationManagedServicesDto> getByManagedId(String managedid) {
	
		return managedRepo.findById(managedid);
	}

//10-pathfinder_asset_classification_hosted


	public AssetClassificationHostedCbsDto hosted_calculation(AssetClassificationHostedCbsDto host,
			String itrunspendid1, String inputtablesid2, String itspendcategoriesid3) {
		ItRunSpendDto run=runRepo.findById(itrunspendid1).get();
		InputTablesDto inp=inputRepo.findById(inputtablesid2).get();
		ItSpendCategoriesDto isc=spendRepo.findById(itspendcategoriesid3).get();

		AssetClassificationHostedCbsDto obj3= help.hostedCalculation(host, run, inp, isc);

		obj3=hostedRepo.save(obj3);
		return obj3;
	}
	
	public Optional<AssetClassificationHostedCbsDto> getByHostedId(String hostedid) {
		// TODO Auto-generated method stub
		return hostedRepo.findById(hostedid);
	}
	
	//11-pathfinder_asset_total

	public AssetClassificationDto itSpendAsset_calc(String hardwareid1, String softwareid2, String managedid3,
			String hostedid4) {
		
		
		AssetClassificationHardwareDto h=hardRepo.findById(hardwareid1).get();
		AssetClassificationSoftwareDto s=softRepo.findById(softwareid2).get();
		AssetClassificationManagedServicesDto m=managedRepo.findById(managedid3).get();
		AssetClassificationHostedCbsDto host=hostedRepo.findById(hostedid4).get();
		AssetClassificationDto obj1=help.itspendcalculation(h, s, m, host);
		obj1= assetRepo.save(obj1);
		return obj1;
		
		    
	}
	//12-pathfinder_saving_optimization
	public SavingsOptimizationDto saving_calculation(String hardwareid1, String softwareid2, String managedid3,
			String hostedid4, String itpersonelid5, String costtransid6, String itrunspendid7) {
		AssetClassificationHardwareDto h=hardRepo.findById(hardwareid1).get();
		AssetClassificationSoftwareDto s=softRepo.findById(softwareid2).get();
		AssetClassificationManagedServicesDto m=managedRepo.findById(managedid3).get();
		AssetClassificationHostedCbsDto host=hostedRepo.findById(hostedid4).get();
		ItPersonnelDto itp=itpersonalRepo.findById(itpersonelid5).get();
		CostofTransformationDto cot=cotRepo.findById(costtransid6).get();
		ItRunSpendDto run=runRepo.findById(itrunspendid7).get();
		
		SavingsOptimizationDto obj2=help.savingsoptimizationcalculation(h, s, m, host,itp,cot,run);
		obj2= savingRepo.save(obj2);
		return obj2;
	}
	//13-pathfinder_itspend_run_personnel
	public ItSpendOnRunPersonnelDto runPersonnel_calc(String itpersonnelid1, String inputtablesid2, String costtransformationid3) {
		 InputTablesDto obj=inputRepo.findById(inputtablesid2).get();
	        CostofTransformationDto obj1=cotRepo.findById(costtransformationid3).get();
	        ItPersonnelDto obj2= itpersonalRepo.findById(itpersonnelid1).get();
	        ItSpendOnRunPersonnelDto obj3= help.runpersonnelcalculation(obj2, obj, obj1);
	        obj3=itrunRepo.save(obj3);
	        
	        return obj3;   
	}

	

	
	

	
}
