package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_year_based_transformation")

public class YearBasedTransformationDto {
	
	private int year;
	private double cot_spread_perc;
	private long client_share_value;
	private long partner_share_value;
	private long total_with_inflation;
	
	public YearBasedTransformationDto(int year, double cot_spread_perc) {
		super();
		this.year = year;
		this.cot_spread_perc = cot_spread_perc;
	}

	public YearBasedTransformationDto()
	{
		
	}
}
