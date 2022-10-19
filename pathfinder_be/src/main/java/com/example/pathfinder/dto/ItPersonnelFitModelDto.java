package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_itpersonnel_fit_model")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItPersonnelFitModelDto {
	private String id;
	private int client_baseyear;
	private long client_fte_baseyear;
	
	private int partner_fte_baseyear;
	private int fte_onsite_baseyear;
	private int fte_offshore_baseyear;
	
	private int partner_bill_baseyear;
	private int bill_onsite_baseyear;
	private int bill_offshore_baseyear;
	
	private long total_spend_baseyear;
	private long total_partner;
	private long total_sum_spend;
	
	ArrayList<ItPersonnelFitModelYear> fitcalc;
}