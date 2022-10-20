package com.example.pathfinder.dto;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_personnel_cost")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItPersonalCostDto {
    
	private String id;
	private long partnerCtcOnsite;
	private long partnerCtcOffshore;
	private double onsitRatio;
	private double offshoreRatio;
	
	
	private List<YearBasedOutsourcingDto> yearBseCalculations;
	
	public ItPersonalCostDto(long partnerCtcOnsite, long partnerCtcOffshore, double onsitRatio, double offshoreRatio,
			List<YearBasedOutsourcingDto> yearBseCalculations) {
		super();
		this.partnerCtcOnsite = partnerCtcOnsite;
		this.partnerCtcOffshore = partnerCtcOffshore;
		this.onsitRatio = onsitRatio;
		this.offshoreRatio = offshoreRatio;
		this.yearBseCalculations = yearBseCalculations;
	}
	
	public ItPersonalCostDto() {
		
	}
	
}
