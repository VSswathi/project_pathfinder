package com.example.pathfinder_be.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_year_based_transformation")

public class YearBasedTransformationDto {
	
	private String id;
	private int year;
	private double cot_spread_perc;
	private long client_share_value;
	private long partner_share_value;
	private long total_with_inflation;

}
