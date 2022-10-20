package com.example.pathfinder.dto;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@Document(collection="pathfinder_asset_classification_software")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetClassificationSoftwareDto {
	private String id;
	private double perc_split_software;
	private long baseLine_software;
	private float total_rationalize;
	private float total_std_platform;
	private float total_transform;
	private float total_eliminate;
	private float total_perc_s;
	private double total_value_s;
	
	private List<AssetClassificationSoftwareYear> softwareCalculations;

	public AssetClassificationSoftwareDto(List<AssetClassificationSoftwareYear> softwareCalculations) {
		super();
		this.softwareCalculations = softwareCalculations;
	}

	public AssetClassificationSoftwareDto() {}
	

}
