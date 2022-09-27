package com.example.pathfinder_be.dto;

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
}