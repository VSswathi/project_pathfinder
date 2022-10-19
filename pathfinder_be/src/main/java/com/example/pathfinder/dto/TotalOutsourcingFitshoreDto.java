package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_total_outsource_fitshore")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalOutsourcingFitshoreDto {
	private String id;
	private long sum_totoal_outsource_fit;
	private long sum_onsite_offshore_model;
	private long sum_cot_partner_share;
	private long sum_total_savings_yoy;
	private float main_total_savings_yoy;
	
	private List<TotalOutsourcingFitshoreYear> outsourceFitCalc;
	
}