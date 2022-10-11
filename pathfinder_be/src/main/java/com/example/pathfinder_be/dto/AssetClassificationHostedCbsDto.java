package com.example.pathfinder_be.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_classification_hosted")
public class AssetClassificationHostedCbsDto {

	private String id;
	private double perc_split_hosted_cbs;
	private long baseLine_hosted_cbs;
	
	
	private float total_transform_cloud;
	private float total_perc_host;
	private float total_value_host;
	
	private List<AssetClassificationHostedCbsYear> hosted_cbsCalculations;
	
}
