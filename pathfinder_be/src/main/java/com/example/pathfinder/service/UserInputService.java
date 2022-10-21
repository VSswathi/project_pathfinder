package com.example.pathfinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder.dto.AssetClassificationDto;
import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItFunctionsDto;
import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItPersonnelFitModelDto;
import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItSpendCategoriesDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunItOutsourceCostsDto;
import com.example.pathfinder.dto.RunItOutsourceFteDto;
import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.RunOpexModelingOutsourceDto;
import com.example.pathfinder.dto.RunOpexModelling2ADto;
import com.example.pathfinder.dto.RunOpexModellingDto;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.dto.UserDetailsDto;
import com.example.pathfinder.dto.UserInputDto;
import com.example.pathfinder.dto.UserValuesDto;
import com.example.pathfinder.dto.WaterfallTableDto;
import com.example.pathfinder.helper.AssetClassificationCalc;
import com.example.pathfinder.helper.CalculationHelper;
import com.example.pathfinder.helper.ItFunctionsCalc;
import com.example.pathfinder.helper.ModelOptionsCalc;
import com.example.pathfinder.helper.RunItOutsourceCalc;
import com.example.pathfinder.helper.WaterfallCalc;
import com.example.pathfinder.repo.UserDetailsRepo;
import com.example.pathfinder.repo.UserInputRepo;
import com.example.pathfinder.repo.UserValuesRepo;
import com.example.pathfinder.response.Project;
import com.example.pathfinder.response.ProjectNameOnly;

@Service
public class UserInputService {

	@Autowired
	UserInputRepo inputRepo;	
	@Autowired
	CalculationHelper helper;
	@Autowired
	AssetClassificationCalc help;
	@Autowired
	RunItOutsourceCalc runcalc;
	@Autowired
	ItFunctionsCalc func;
	@Autowired
	ModelOptionsCalc model;
	@Autowired
	WaterfallCalc waterfall;
	@Autowired
	UserValuesRepo valueRepo;
	@Autowired
	UserDetailsRepo detailRepo;

// EXISTING USER json
	
	public UserInputDto userInput(UserInputDto inp) {
		UserInputDto calculated=calculate(inp);
		UserInputDto obj=inputRepo.save(calculated);
		
		return obj;
	}
	
	
	public UserInputDto calculate(UserInputDto inp){
		InputTablesDto input_A=helper.calculateValue(inp.getInputvalues());
		ItPersonnelDto input_B=helper.calcValue(inp.getItpersonnel(), input_A);
		ItPersonalCostDto input_C=helper.yearBasedCalculation(input_B, inp.getItpersonalcost());
		CostofTransformationDto input_D=helper.YearBasedTransformation(inp.getCost(), input_A);
		ItSpendCategoriesDto input_E=helper.itspend_categories_calc(inp.getItspendcat());
		ItRunSpendDto input_F=help.yearBasedCalculation(input_B, input_A, input_D);
		AssetClassificationHardwareDto input_G=help.hardwareCalculation(inp.getHardware(), input_F, input_A, input_E);
		AssetClassificationSoftwareDto input_H=help.softwareCalculation(inp.getSoftware(), input_F, input_A, input_E);
		AssetClassificationManagedServicesDto input_I=help.managedCalculation(inp.getManaged(), input_F, input_A, input_E);
		AssetClassificationHostedCbsDto input_J=help.hostedCalculation(inp.getHostedcbs(), input_F, input_A, input_E);
		AssetClassificationDto input_K=help.itspendcalculation(input_G, input_H, input_I, input_J);
		SavingsOptimizationDto input_L=help.savingsoptimizationcalculation(input_G, input_H, input_I, input_J, input_B, input_D, input_F);
		ItSpendOnRunPersonnelDto input_M=help.runpersonnelcalculation(input_B, input_A, input_D);
		RunItOutsourceFteDto input_N=runcalc.runfteCalc(input_A, input_B, input_C);
		RunItOutsourceCostsDto input_O=runcalc.runCostsCalc(input_A, input_B, input_C, input_N);
		ItPersonnelFitModelDto input_P=runcalc.personnelFitCalc(input_A, input_C, input_N, input_O);
		AssetOutsourceOnsiteDto input_Q=runcalc.outsourceOnsiteCalc(input_B, input_D, input_M, input_O);
		TotalOutsourcingFitshoreDto input_R=runcalc.outsourceFitCalc(input_B, input_D, input_P, input_M);
		ItFunctionsDto input_S=func.calculateValue(inp.getItfunctions(), input_A, input_B);
		AssetClassificationDto input_T= help.itspendcalculation(input_G, input_H, input_I, input_J);
		
		TotalSavingsModel2BDto input_a= model.model2bcalculation(input_F, input_L, input_M, input_R);
		RunOpexModelingFitshoreDto input_b= model.runfit_calculation(input_a);
		RunOpexModellingDto input_c=model.runopex_calculation(input_b);
		TotalSavingsModel2ADto input_d= model.model2a_calculation(input_F, input_L, input_M, input_Q, input_a);
		RunOpexModelingOutsourceDto input_e= model.runoutsource_calculation(input_d, input_a);
		RunOpexModelling2ADto input_f= model.runopex2a_calculation(input_e);
		WaterfallTableDto input_g=waterfall.calculateValue(input_a, input_d);
		
		UserInputDto final_json=new UserInputDto();
		final_json.setUserId(inp.getUserId());
		final_json.setProjectName(inp.getProjectName());
		final_json.setInputvalues(input_A);
		final_json.setItpersonnel(input_B);
		final_json.setItpersonalcost(input_C);
		final_json.setCost(input_D);
		final_json.setItspendcat(input_E);
		final_json.setItrunspend(input_F);
		final_json.setHardware(input_G);
		final_json.setSoftware(input_H);
		final_json.setManaged(input_I);
		final_json.setHostedcbs(input_J);
		final_json.setAsset(input_K);
		final_json.setSavings(input_L);
		final_json.setItspendrun(input_M);
		final_json.setRunitfte(input_N);
		final_json.setRunitcost(input_O);
		final_json.setItpersfit(input_P);
		final_json.setOutsourceonsite(input_Q);
		final_json.setTotalfitshore(input_R);
		final_json.setItfunctions(input_S);
		final_json.setAsset(input_T);
		
		final_json.setTotal2B(input_a);
		final_json.setRunopexfit(input_b);
		final_json.setModel2B(input_c);
		final_json.setTotal2A(input_d);
		final_json.setRunopexoutsource(input_e);
		final_json.setModel2A(input_f);
		final_json.setWaterfall(input_g);
		
		return final_json;
	}

	public Optional<UserInputDto> getByInputId(String inputid) {
		return inputRepo.findById(inputid);
	}

	public List<UserInputDto> getAllUserInputs() {
		return inputRepo.findAll();
	}
	
	
	public UserInputDto updateUserInput(UserInputDto tocalculate, String inputid) {
		UserInputDto final_json =inputRepo.findById(inputid).get();
		 final_json=calculate(tocalculate);
		 final_json.setId(inputid);
		return inputRepo.save(final_json);
	}
	
	public UserInputDto updateUserInputonly_one(long inp, String inputid) {
		UserInputDto final_json =inputRepo.findById(inputid).get();
		InputTablesDto obj=final_json.getInputvalues();
		obj.setAnnual_revenue_for_client(inp);
		final_json.setInputvalues(obj);
		final_json=calculate(final_json);
		final_json.setId(inputid);

		return inputRepo.save(final_json);
	}
	

// NEW USER Values (only post methods)

	public UserValuesDto allInputValues(String userinputid1) {
		
		UserInputDto obj=inputRepo.findById(userinputid1).get();
		UserValuesDto inputonly=input_with_calculated_value(obj);
		inputonly.setId(userinputid1);

		return valueRepo.save(inputonly);
	}
	
	public UserValuesDto input_with_calculated_value(UserInputDto obj)
	{
		UserValuesDto inpu_only=new UserValuesDto();
		
		inpu_only.setInputvalues(obj.getInputvalues());
		inpu_only.setItpersonnel(obj.getItpersonnel());
		inpu_only.setItpersonalcost(obj.getItpersonalcost());
		inpu_only.setCost(obj.getCost());
		inpu_only.setItspendcat(obj.getItspendcat());
		inpu_only.setHardware(obj.getHardware());
		inpu_only.setSoftware(obj.getSoftware());
		inpu_only.setManaged(obj.getManaged());
		inpu_only.setHostedcbs(obj.getHostedcbs());
		inpu_only.setItfunctions(obj.getItfunctions());
			
		return inpu_only;
		
	}

	public ProjectNameOnly getAllProjectNAme_only() {
        List<UserInputDto> obj=inputRepo.findAll();
        List<String> projectName=new ArrayList<>();
        for(UserInputDto nn:obj) {
            projectName.add(nn.getProjectName());
        }
        ProjectNameOnly obj1=new ProjectNameOnly();
        obj1.setListOfProjectName(projectName);
//        obj1.setStatus("SUCCESS");
    
        return obj1;
	}

	public ProjectNameOnly getAllProjectNAme_only(String userid) {

		List<UserInputDto> obj=inputRepo.findByUserId(userid);
		List<String> projectName=new ArrayList<>();
		for(UserInputDto nn:obj) {
			projectName.add(nn.getProjectName());
		}
		ProjectNameOnly obj1=new ProjectNameOnly();
		obj1.setListOfProjectName(projectName);
	
		return obj1;
	}
	
	
	
//User Details(First page)
	
	public UserInputDto userDetails(UserDetailsDto inp) {
		UserInputDto obj=inputRepo.findByUserIdAndProjectName(inp.getUserId(),inp.getProjectName());
		
		return obj;
	}


	public Optional<UserDetailsDto> getByDetailsId(String detalsid) {
		return detailRepo.findById(detalsid);
	}


	public UserInputDto get_byProjectName(String projectname) {
		UserInputDto obj=inputRepo.findByProjectName(projectname);
	
		return obj;
	}




	
}