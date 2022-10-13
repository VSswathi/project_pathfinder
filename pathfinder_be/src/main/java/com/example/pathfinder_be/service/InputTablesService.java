package com.example.pathfinder_be.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.helper.AssetClassificationCalc;
import com.example.pathfinder_be.helper.CalculationHelper;
import com.example.pathfinder_be.repo.CostofTransformationRepo;
import com.example.pathfinder_be.repo.InputTablesRepo;
import com.example.pathfinder_be.repo.ItPersonalCostRepo;
import com.example.pathfinder_be.repo.ItRunSpendRepo;
import com.example.pathfinder_be.repo.ItpersonelRepo;



@Service
public class InputTablesService {

	@Autowired
	InputTablesRepo inputRepo;

  @Autowired
  ItpersonelRepo itpersonalRepo;
  
  
  @Autowired
  ItPersonalCostRepo costRepo;
  
  @Autowired
  CalculationHelper helper;
  
  @Autowired
  CostofTransformationRepo cotRepo;
  @Autowired
  AssetClassificationCalc help;
  @Autowired
  ItRunSpendRepo runRepo;
    
    
//1-pathfinder_input_tables
	public InputTablesDto input_tables_final(InputTablesDto inp) {
		InputTablesDto obj=helper.calculateValue(inp);
		inputRepo.save(obj);
     	return obj;
	}
	
	
	public InputTablesDto updateInputTables(InputTablesDto inp, String inputtablesid) {
		
        InputTablesDto old=inputRepo.findById(inputtablesid).get();
		old.setId(inp.getId());
		old.setAnnual_inflation_perc(inp.getAnnual_inflation_perc());
		old.setAnnual_revenue_for_client(inp.getAnnual_revenue_for_client());
		old.setIt_spent_perc(inp.getIt_spent_perc());
		old.setGrow_business_perc(inp.getGrow_business_perc());
		old.setTransform_it_perc(inp.getTransform_it_perc());
		return inputRepo.save(old);
	
	}
	
	public Optional<InputTablesDto> getByInputTablesId(String inputtablesid) {
		return inputRepo.findById(inputtablesid);
	}
	
	
	// 2-pathfinder_it_personnel
	public ItPersonnelDto it_personal_final(ItPersonnelDto itp, String id) {
		InputTablesDto obj=inputRepo.findById(id).get();
		ItPersonnelDto object=helper.calcValue(itp,obj);
		return object=itpersonalRepo.save(object);
	}
	
	public Optional<ItPersonnelDto> getByitPersonalId(String itpersonelid) {
		return itpersonalRepo.findById(itpersonelid);
	}
	
	public ItPersonnelDto updateItPersonnel(ItPersonnelDto itp, String itpersonelid) {
		ItPersonnelDto old1=itpersonalRepo.findById(itpersonelid).get();
		old1.setId(itp.getId());
		old1.setIt_spend_on_personal_perc(itp.getIt_spend_on_personal_perc());
		old1.setAvr_ctc_per_fte(itp.getAvr_ctc_per_fte());
		old1.setPerc_eligible_forpersonal(itp.getPerc_eligible_forpersonal());
		return itpersonalRepo.save(old1);
	}

	// 3-pathfinder_it_personnel_cost 	
	public ItPersonalCostDto it_personal_cost_final(ItPersonalCostDto icp, String id) {
		ItPersonnelDto itpc_final=itpersonalRepo.findById(id).get();
		ItPersonalCostDto  obj3=helper.yearBasedCalculation(itpc_final,icp);
		 obj3=costRepo.save(obj3);
	     return obj3;
	}

	public Optional<ItPersonalCostDto> getByitPersonalCostId(String itpersonelcostid) {
		return costRepo.findById(itpersonelcostid);

	}

	public ItPersonalCostDto updateItPersonnelCost(ItPersonalCostDto ipc, String itpersonelcostid,String itpersonnelid) {
		ItPersonalCostDto old2=costRepo.findById(itpersonelcostid).get();
		ItPersonnelDto itpc_final=itpersonalRepo.findById(itpersonnelid).get();
		old2.setId(ipc.getId());
		
		old2.setOffshoreRatio(ipc.getOffshoreRatio());
		old2.setOnsitRatio(ipc.getOnsitRatio());
		old2.setPartnerCtcOnsite(ipc.getPartnerCtcOnsite());
		old2.setPartnerCtcOffshore(ipc.getPartnerCtcOffshore());		
		old2.setYearBseCalculations(helper.yearBasedCalculation(itpc_final, ipc).getYearBseCalculations());
		return costRepo.save(old2);
	}

	

	// 4-pathfinder_cost_of_transformation
	public CostofTransformationDto costTransformation_calc(CostofTransformationDto inp, String id) {

		InputTablesDto obj=inputRepo.findById(id).get();
		CostofTransformationDto  obj4=helper.YearBasedTransformation(inp,obj);
		 obj4=cotRepo.save(obj4);
	     return obj4;
	}
	
	public Optional<CostofTransformationDto> getByCostId(String costid) {
		return cotRepo.findById(costid);
	}

	public CostofTransformationDto updateCost(CostofTransformationDto cot, String costid, String inputtablesid) {
		CostofTransformationDto old3=cotRepo.findById(costid).get();
		InputTablesDto input_final=inputRepo.findById(inputtablesid).get();
		old3.setId(cot.getId());
		
		old3.setCot_perc(cot.getCot_perc());
		old3.setClient_perc(cot.getClient_perc());
		old3.setPartner_perc(cot.getPartner_perc());
		old3.setYearBaseCostCalculations(helper.YearBasedTransformation(cot, input_final).getYearBaseCostCalculations());
		return cotRepo.save(old3);
	}

	   //6-pathfinder_itrun_spend
	
public ItRunSpendDto itRunSpend_calc(String id1, String id2, String id3) {
        
        InputTablesDto obj=inputRepo.findById(id2).get();
        CostofTransformationDto obj1=cotRepo.findById(id3).get();
        ItPersonnelDto obj2= itpersonalRepo.findById(id1).get();
        ItRunSpendDto obj3= help.yearBasedCalculation(obj2, obj, obj1);
        obj3=runRepo.save(obj3);
        
        return obj3;    



   }





}