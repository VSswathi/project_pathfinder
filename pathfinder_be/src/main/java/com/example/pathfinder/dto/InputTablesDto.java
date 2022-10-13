package com.example.pathfinder.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
@Document(collection="pathfinder_input_tables")
public class InputTablesDto {
	
	private String id;
    private long annual_revenue_for_client;//11,170,000,00
    private double it_spent_perc; //2.5%
    private long it_spent_value;//(annual_revenue_for_client*it_spent_perc)
    
    private double run_business_perc; //65.0%
    private long run_business_value;//(run_business_perc*it_spent_value)
    
    private double grow_business_perc;//23.0%
    private long grow_business_value;//(grow_business_perc*it_spent_value)
    
    private double transform_it_perc;//12.0%
    private long transform_it_value;//(transform_it_perc*it_spent_value)
    
    private double annual_inflation_perc;//3%
    


   
}