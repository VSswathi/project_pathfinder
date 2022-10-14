package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection="pathfinder_run_opex_outsource")
public class RunOpexModelingOutsourceDto {

	private String id;
	private long client_drives_baseyear;
	private long with_partner_hs_baseyear;
	private long with_partner_personnel_baseyear;
	private long total_partner_baseyear;
	
	private long with_partner_hs_cumulative;
	private long with_partner_personnel_cumulative;
	private long total_partner_cumulative;
	
	private long total_client_drives;
	private long total_with_partner_hs;
	private long total_with_partner_personnel;
	private long sum_total_partner;
	
	
	ArrayList<RunOpexModelingOutsourceYear> runoutsourcecalculation;
}
