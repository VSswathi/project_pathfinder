package com.example.pathfinder_be.dto;

import lombok.Data;

@Data
public class ItPersonnelFitModelYear {

	private int year;
	
	private int client_year;
	private long client_fte_year;
	
	private int partner_fte_total;
	private int fte_onsite;
	private int fte_offshore;
	private long partner_bill_total;
	private long bill_onsite;
	private long bill_offshore;
	private long total_spend_for_original;
	
}