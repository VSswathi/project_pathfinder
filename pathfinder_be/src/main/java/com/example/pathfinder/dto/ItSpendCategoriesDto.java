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
	
}
