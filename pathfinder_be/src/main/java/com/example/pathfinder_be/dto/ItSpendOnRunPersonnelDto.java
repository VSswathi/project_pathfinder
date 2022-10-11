package com.example.pathfinder_be.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_itspend_run_personnel")
public class ItSpendOnRunPersonnelDto {

	private String id;
	private long itspend_baseline;
	private long total_itSpendWithInflation;
    private double total_cotClientShare;
    private long total_yearlyRunRate;
	
	
	ArrayList<ItSpendOnRunPersonnelYear> runpersonnelcalculation;
}