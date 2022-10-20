package com.example.pathfinder.dto;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_cost_of_transformation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostofTransformationDto {
	
	private String id;
	private double cot_perc;
	private long cot_value;
	private double client_perc;
	private long client_value;
	private double partner_perc;
	private long partner_value;
	
	private List<YearBasedTransformationDto> yearBaseCostCalculations;
	
	public CostofTransformationDto(double cot_perc, double client_perc, double partner_perc,
			List<YearBasedTransformationDto> yearBaseCostCalculations) {
		super();
		this.cot_perc = cot_perc;
		this.client_perc = client_perc;
		this.partner_perc = partner_perc;
		this.yearBaseCostCalculations = yearBaseCostCalculations;
	}


	public CostofTransformationDto() {
		
	}
	
}
