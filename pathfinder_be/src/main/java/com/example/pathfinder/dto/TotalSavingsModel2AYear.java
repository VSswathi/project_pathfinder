package com.example.pathfinder.dto;

import lombok.Data;

@Data
public class TotalSavingsModel2AYear {

	private int year;
	private long hardware_software_client_spend_without_partner;
	private long hardware_software_client_spend_with_partner;
	private long hardware_software_cost_reduction;
	
	private long personnel_outsourcing_client_spend_without_partner;
	private long personnel_outsourcing_client_spend_with_partner;
	private long personnel_outsourcing_cost_reduction;
	
	private long totals_client_spend_without_partner;
	private long totals_client_spend_with_partner;
	private long totals_cost_reduction;
	
	private long cumulative_savings;
}
