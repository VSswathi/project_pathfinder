package com.example.pathfinder_be.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_classification_hardware")
public class AssetClassificationHardwareDto {
	private String id;
	private double perc_split_hardware;
	private long baseLine_hardware;
	private float total_eliminateReduc;
	private float total_eliminateRetire;
	private float total_consolidate;
	private float total_rationalize;
	private float total_perc_h;
	private double total_value_h;

	
	private List<AssetClassificationHardwareYear> hardwareCalculations;

}
