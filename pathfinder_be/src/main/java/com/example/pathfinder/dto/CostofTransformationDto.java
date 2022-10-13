package com.example.pathfinder.dto;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_cost_of_transformation")

public class CostofTransformationDto {
	
	private String id;
	private double cot_perc;
	private long cot_value;
	private double client_perc;
	private long client_value;
	private double partner_perc;
	private long partner_value;
	
	
	private List<YearBasedTransformationDto> yearBaseCostCalculations;

	
}
