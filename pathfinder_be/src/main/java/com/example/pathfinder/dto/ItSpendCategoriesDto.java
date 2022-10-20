package com.example.pathfinder.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_spend_categories")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItSpendCategoriesDto {
	private String id;
	private int year;
	private double hardware;
	private double software;
	private double hosted_cbs;
	private double managedServices;
	public ItSpendCategoriesDto(int year, double hardware, double software, double hosted_cbs, double managedServices) {
		super();
		this.year = year;
		this.hardware = hardware;
		this.software = software;
		this.hosted_cbs = hosted_cbs;
		this.managedServices = managedServices;
	}
	
	public ItSpendCategoriesDto() {
		
	}
	
}
