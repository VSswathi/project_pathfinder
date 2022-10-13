package com.example.pathfinder.dto;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_personnel_cost")

public class ItPersonalCostDto {
    
	private String id;
	private long partnerCtcOnsite;
	private long partnerCtcOffshore;
	private double onsitRatio;
	private double offshoreRatio;
	
	
	private List<YearBasedOutsourcingDto> yearBseCalculations;
	
}
