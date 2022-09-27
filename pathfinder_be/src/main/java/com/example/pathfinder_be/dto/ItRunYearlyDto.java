package com.example.pathfinder_be.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_itrun_yearly")
public class ItRunYearlyDto {

	private int year;
	private double itSpendWithInflation;
	private double cotClientShare;
	private double yearlyRunRate;
	
}
