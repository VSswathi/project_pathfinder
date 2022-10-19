package com.example.pathfinder.dto;



import java.util.List;



import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;



@Data
@Document(collection="pathfinder_asset_classification_managed")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetClassificationManagedServicesDto {


	private String id;
    private double perc_split_managed_services;
    private long baseLine_managed_services;
    
    private float total_ishiftleft;
    private float total_std_iautomate;
    private float total_irealtime;
    private float total_synergize;
    private float total_perc_m;
    private float total_value_m;
    
    private List<AssetClassificationManagedServicesYear> managed_servicesCalculations;



}