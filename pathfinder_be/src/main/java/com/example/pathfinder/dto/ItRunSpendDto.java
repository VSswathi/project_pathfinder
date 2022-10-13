package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_itrun_spend")
public class ItRunSpendDto {

	private String id;
	private long baseLineYearSpend;
	
	private long total_itSpendWithInflation;
    private double total_cotClientShare;
    private long total_yearlyRunRate;
	
	private List<ItRunYearlyDto> runCalc;
}
