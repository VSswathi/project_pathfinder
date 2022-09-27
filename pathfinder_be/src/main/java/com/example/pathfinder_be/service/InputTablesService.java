package com.example.pathfinder_be.service;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.dto.YearBasedOutsourcingDto;
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
    
    
// Table-1
	public InputTablesDto input_tables_final(InputTablesDto inp) {
		InputTablesDto obj=helper.calculateValue(inp);
		inputRepo.save(obj);
     	return obj;
	}
	
	
	public Optional<InputTablesDto> getById(String id) {
		return inputRepo.findById(id);
	}

	
// Table-2
	public ItPersonnelDto it_personal_final(ItPersonnelDto itp, String id) {
		InputTablesDto obj=inputRepo.findById(id).get();
		ItPersonnelDto object=helper.calcValue(itp,obj);
		 object=itpersonalRepo.save(object);
	     return object;
	}
	
	
//Table-3	
	public ItPersonalCostDto it_personal_cost_final(ItPersonalCostDto icp, String id) {
		ItPersonnelDto itpc_final=itpersonalRepo.findById(id).get();
		ItPersonalCostDto  obj3=helper.yearBasedCalculation(itpc_final,icp);
		 obj3=costRepo.save(obj3);
	     return obj3;
	}

	

//Table-4
	public CostofTransformationDto costTransformation_calc(CostofTransformationDto inp, String id) {

		InputTablesDto obj=inputRepo.findById(id).get();
		CostofTransformationDto  obj4=helper.YearBasedTransformation(inp,obj);
		 obj4=cotRepo.save(obj4);
	     return obj4;
	}



//	public Optional<CostofTransformationDto> getAllCostId(String id) {
//		// TODO Auto-generated method stub
//		return cotRepo.findById(id);
//	}


	
	
public ItRunSpendDto itRunSpend_calc(String id1, String id2, String id3) {
        
        InputTablesDto obj=inputRepo.findById(id2).get();
        CostofTransformationDto obj1=cotRepo.findById(id3).get();
        ItPersonnelDto obj2= itpersonalRepo.findById(id1).get();
        ItRunSpendDto obj3= help.yearBasedCalculation(obj2, obj, obj1);
        obj3=runRepo.save(obj3);
        
        return obj3;    



   }
}