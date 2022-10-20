package com.example.pathfinder.hardcode;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHardwareYear;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsYear;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesYear;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareYear;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItFunctionsDto;
import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItSpendCategoriesDto;
import com.example.pathfinder.dto.YearBasedOutsourcingDto;
import com.example.pathfinder.dto.YearBasedTransformationDto;

@Component
public class InitialValue {
	
  public String getHardcodeValue() {
	  
	  InputTablesDto input_tables=new InputTablesDto(11170000000l,2.5,65,23,12,3);
	  
	  ItPersonnelDto itpersonnel_dto= new ItPersonnelDto(67,150000,85);
	  
	  ArrayList<YearBasedOutsourcingDto> itpersonal_cost_dto=new ArrayList<YearBasedOutsourcingDto>();
	  YearBasedOutsourcingDto itc1=new YearBasedOutsourcingDto( 1,25,3,80,20);
	  itpersonal_cost_dto.add(itc1);
	  YearBasedOutsourcingDto itc2=new YearBasedOutsourcingDto( 2,50,5,50,50 );
	  itpersonal_cost_dto.add(itc2);
	  YearBasedOutsourcingDto itc3=new YearBasedOutsourcingDto( 3,25,2,20,80 );
	  itpersonal_cost_dto.add(itc3);
	  
	  ItPersonalCostDto itp=new ItPersonalCostDto(115000,20000,20,80,itpersonal_cost_dto);
	  
	  ArrayList<YearBasedTransformationDto>cost_dto=new ArrayList<YearBasedTransformationDto>();
	  YearBasedTransformationDto year1=new YearBasedTransformationDto( 1,30);
	  cost_dto.add(year1);
	  YearBasedTransformationDto year2=new YearBasedTransformationDto( 2,50 );
	  cost_dto.add(year2);
	  YearBasedTransformationDto year3=new YearBasedTransformationDto( 3,20 );
	  cost_dto.add(year3);
	  
	  CostofTransformationDto cot=new CostofTransformationDto(10,55,45,cost_dto);
	  
	  ItSpendCategoriesDto spend=new ItSpendCategoriesDto(2022,31,29,24,16);
	  
	  ItFunctionsDto func=new ItFunctionsDto(22,9,5,11,18,25,10,12,8,8,6,24,30,12);
	  
	  ArrayList<AssetClassificationHardwareYear>hardware_dto=new ArrayList<AssetClassificationHardwareYear>();
	  AssetClassificationHardwareYear hard1=new AssetClassificationHardwareYear( 1,0.15f,0.30f,0.20f,0.50f);
	  hardware_dto.add(hard1);
	  AssetClassificationHardwareYear hard2=new AssetClassificationHardwareYear( 2,0.10f,0.20f,0.50f,2.0f);
	  hardware_dto.add(hard2);
	  AssetClassificationHardwareYear hard3=new AssetClassificationHardwareYear( 3,0.0f,0.0f,0.0f,2.50f );
	  hardware_dto.add(hard3);
	  
	  AssetClassificationHardwareDto hardware=new AssetClassificationHardwareDto(hardware_dto);
	  
	  ArrayList<AssetClassificationSoftwareYear> software_dto=new ArrayList<AssetClassificationSoftwareYear>();
	  AssetClassificationSoftwareYear soft1=new AssetClassificationSoftwareYear( 1,1.00f,1.00f,1.00f,0.15f);
	  software_dto.add(soft1);
	  AssetClassificationSoftwareYear soft2=new AssetClassificationSoftwareYear( 2,1.50f,2.00f,0.50f,0.10f);
	  software_dto.add(soft2);
	  AssetClassificationSoftwareYear soft3=new AssetClassificationSoftwareYear( 3,1.00f,1.00f,0.00f,0.00f );
	  software_dto.add(soft3);
	  
	  AssetClassificationSoftwareDto software=new AssetClassificationSoftwareDto(software_dto);
	  
	  ArrayList<AssetClassificationManagedServicesYear> managed_dto=new ArrayList<AssetClassificationManagedServicesYear>();
	    AssetClassificationManagedServicesYear mang1=new AssetClassificationManagedServicesYear( 1,1.0f,0.5f,0.0f,0.0f);
	    managed_dto.add(mang1);
	    AssetClassificationManagedServicesYear mang2=new AssetClassificationManagedServicesYear( 2,1.50f,1.f,0.50f,0.10f);
	    managed_dto.add(mang2);
	    AssetClassificationManagedServicesYear mang3=new AssetClassificationManagedServicesYear( 3,0.50f,2.0f,0.0f,0.20f);
	    managed_dto.add(mang3);
	    
	    AssetClassificationManagedServicesDto managed=new AssetClassificationManagedServicesDto(managed_dto);
	  
	  ArrayList<AssetClassificationHostedCbsYear> hosted_dto=new ArrayList<AssetClassificationHostedCbsYear>();
	  AssetClassificationHostedCbsYear host1=new AssetClassificationHostedCbsYear( 1,2);
	  hosted_dto.add(host1);
	  AssetClassificationHostedCbsYear host2=new AssetClassificationHostedCbsYear( 2,5);
	  hosted_dto.add(host2);
	  AssetClassificationHostedCbsYear host3=new AssetClassificationHostedCbsYear( 3,7 );
	  hosted_dto.add(host3);
	  
	  AssetClassificationHostedCbsDto hosted=new AssetClassificationHostedCbsDto(hosted_dto);
	  
	
	  //-------------
	  
	return null;
  }

}
