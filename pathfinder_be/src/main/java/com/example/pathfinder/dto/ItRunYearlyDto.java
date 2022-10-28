package com.example.pathfinder.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_itrun_yearly")
public class ItRunYearlyDto {

	private int year;
	private long itSpendWithInflation;
	private long cotClientShare;
	private long yearlyRunRate;
	
}
