package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document (collection="pathfinder_total_savings_model2a")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalSavingsModel2ADto {

	private String id;
	private long hardware_software_baseyear;
	private long personnel_outsourcing_baseyear;
	private long totals_baseyear;
	
	private long total_hardware_software_client_spend_without_partner;
	private long total_hardware_software_client_spend_with_partner;
	private long total_hardware_software_cost_reduction;
	
	private long total_personnel_outsourcing_client_spend_without_partner;
	private long total_personnel_outsourcing_client_spend_with_partner;
	private long total_personnel_outsourcing_cost_reduction;
	
	private long sum_totals_client_spend_without_partner;
	private long sum_totals_client_spend_with_partner;
	private long sum_totals_cost_reduction;
	
	ArrayList<TotalSavingsModel2AYear> model2acalculation;
}
