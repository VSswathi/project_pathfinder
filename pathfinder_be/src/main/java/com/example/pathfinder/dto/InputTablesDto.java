package com.example.pathfinder.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;



@Data
@Document(collection="pathfinder_input_tables")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputTablesDto {
	
	private String id;
    private long annual_revenue_for_client;
    private double it_spent_perc;
    private long it_spent_value;
    
    private double run_business_perc; 
    private long run_business_value;
    
    private double grow_business_perc;
    private long grow_business_value;
    
    private double transform_it_perc;
    private long transform_it_value;
    
    private double annual_inflation_perc;
    
	public InputTablesDto(long annual_revenue_for_client, double it_spent_perc, double run_business_perc,
			double grow_business_perc, double transform_it_perc, double annual_inflation_perc) {
		super();
		this.annual_revenue_for_client = annual_revenue_for_client;
		this.it_spent_perc = it_spent_perc;
		this.run_business_perc = run_business_perc;
		this.grow_business_perc = grow_business_perc;
		this.transform_it_perc = transform_it_perc;
		this.annual_inflation_perc = annual_inflation_perc;
	}

    
    public InputTablesDto() {
    	
    }

   
}