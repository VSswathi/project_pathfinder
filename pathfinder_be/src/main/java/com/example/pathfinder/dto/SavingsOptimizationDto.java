package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_saving_optimization")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SavingsOptimizationDto {
	private String id;
	private long total_saving_levers;
	private long sum_total_savings;
	private long total_run_businessit;
	private long main_total_run_businessit;
	private long total_cot_partner;
	
	ArrayList<SavingsOptimizationYear> savingsoptimizationcalculation;
}
