package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_waterfall_table")
public class WaterfallTableDto {

	private String id;
	private long baseyear_with_partner;
	private long baseyear_without_partner;
	private long year1_with_partner;
	private long year2_with_partner;
	private long year3_with_partner;
	private long exit_runrate_with_partner;
	private long year1_without_partner;
	private long year2_without_partner;
	private long year3_without_partner;
	private long exit_runrate_without_partner;
	
	private long runrate_reduc_with_partner;
	private long runrate_reduc_without_partner;
	private long runrate_perc_with_partner;
	private long runrate_perc_without_partner;
	private long cumulative_savings_with_partner;
}
