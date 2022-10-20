package com.example.pathfinder.hardcode;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.YearBasedOutsourcingDto;

@Component
public class InitialValue {
	
  public String getHardcodeValue() {
	  
	  ArrayList<YearBasedOutsourcingDto> itpersonal_cost_dto=new ArrayList<YearBasedOutsourcingDto>();
	  YearBasedOutsourcingDto itc1=new YearBasedOutsourcingDto( 1,25,3,80,20);
	  itpersonal_cost_dto.add(itc1);
	  YearBasedOutsourcingDto itc2=new YearBasedOutsourcingDto( 2,50,5,50,50 );
	  itpersonal_cost_dto.add(itc2);
	  YearBasedOutsourcingDto itc3=new YearBasedOutsourcingDto( 3,25,2,20,80 );
	  itpersonal_cost_dto.add(itc3);
	  
	  ItPersonalCostDto itp=new ItPersonalCostDto(5665,565,6456,656,itpersonal_cost_dto);
	  
	  
	  
	  //-------------
	  
	return null;
  }

}
