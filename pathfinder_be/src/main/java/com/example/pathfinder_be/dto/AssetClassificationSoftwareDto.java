package com.example.pathfinder_be.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection="pathfinder_asset_classification_software")
public class AssetClassificationSoftwareDto {
	
	private double perc_split_software;
	private long baseLine_software;
	private float total_rationalize;
	private float total_std_platform;
	private float total_transform;
	private float total_eliminate;
	private float total_perc_s;
	private double total_value_s;
	
	private List<AssetClassificationSoftwareYear> softwareCalculations;
	//ArrayList<ItSpendOnAssetsYearlyDto> itspendcalc;

}
