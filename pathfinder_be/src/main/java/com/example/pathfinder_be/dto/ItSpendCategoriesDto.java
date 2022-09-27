package com.example.pathfinder_be.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_spend_categories")
public class ItSpendCategoriesDto {
	
	private int year;
	private double hardware;
	private double software;
	private double hosted_cbs;
	private double managedServices;
	
}
