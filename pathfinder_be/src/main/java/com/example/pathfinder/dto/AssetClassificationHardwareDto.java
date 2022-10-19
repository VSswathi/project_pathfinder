package com.example.pathfinder.dto;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Document(collection="pathfinder_asset_classification_hardware")
@Schema(description = "Hardware Asset Classification ")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
