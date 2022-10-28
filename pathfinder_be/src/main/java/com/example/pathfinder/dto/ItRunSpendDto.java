package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_itrun_spend")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItRunSpendDto {

	private String id;
	private long baseLineYearSpend;
	
	private long total_itSpendWithInflation;
    private long total_cotClientShare;
    private long total_yearlyRunRate;
	
	private List<ItRunYearlyDto> runCalc;
}
