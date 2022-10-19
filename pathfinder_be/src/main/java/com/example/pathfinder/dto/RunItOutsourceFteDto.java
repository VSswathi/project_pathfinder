package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_run_it_outsource_fte")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunItOutsourceFteDto {
	private String id;
	private int client_exist_baseyear;
	private int partner_exist_baseyear;
	private int net_fte_scope_baseyear;
	
	private int total_savings_in_fte;
	private List<RunItOutsourceFteYear> runfteCalc;
}
