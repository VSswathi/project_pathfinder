package com.example.pathfinder.dto;

import lombok.Data;

@Data
public class AssetClassificationHostedCbsYear {
	

	private int year;
	private long spendIncreaseWithInflation_host;
	private float transform_cloud;
	
	
	private float savingSubtotal_perc_host;
	private double savingSubtotal_value_host;
	
	public AssetClassificationHostedCbsYear(int year, float transform_cloud) {
		super();
		this.year = year;
		this.transform_cloud = transform_cloud;
	}
	
	public AssetClassificationHostedCbsYear() {
		
	}
}
