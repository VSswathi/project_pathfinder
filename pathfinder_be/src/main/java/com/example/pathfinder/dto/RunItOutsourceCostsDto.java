package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_run_it_outsource_costs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunItOutsourceCostsDto {
	private String id;
	private int client_spend_baseyear;
	private int partner_bill_baseyear;
	private int total_spend_baseyear;
	
	private int total_client_spend;
	private int total_partner_bill_spend;
	private int total_sum_spend;
	private int net_run_rate;
	private List<RunItOutsourceCostsYear> runCostsCalc;
}