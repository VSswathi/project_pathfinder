package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_classification_software")
public class AssetClassificationSoftwareYear {

	private int year;
	private long spendIncreaseWithInflation_s;
	private float rationalize_refactor;
	
	private float std_platform;
	private float transform_distributed_agile;
	private float eliminate_redundancy;
	
	private float savingSubtotal_perc_s;
	private float savingSubtotal_value_s;
	
	
	public AssetClassificationSoftwareYear(int year, float rationalize_refactor, float std_platform,
			float transform_distributed_agile, float eliminate_redundancy) {
		super();
		this.year = year;
		this.rationalize_refactor = rationalize_refactor;
		this.std_platform = std_platform;
		this.transform_distributed_agile = transform_distributed_agile;
		this.eliminate_redundancy = eliminate_redundancy;
	}
	public AssetClassificationSoftwareYear() {

	}
}