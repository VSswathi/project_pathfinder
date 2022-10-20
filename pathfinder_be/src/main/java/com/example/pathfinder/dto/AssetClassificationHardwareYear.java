package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_classification_hardware")
public class AssetClassificationHardwareYear {

	
	private int year;
	private long spendIncreaseWithInflation_h;
	private float eliminate_reducdancyElimination;
	private float eliminate_retireDecommision;
	private float consolidate_realignRedistribute;
	private float rationalize_automateMl;
	
	
	private float savingSubtotal_perc_h;
	private double savingSubtotal_value_h;
	
	public AssetClassificationHardwareYear(int year, float eliminate_reducdancyElimination,
			float eliminate_retireDecommision, float consolidate_realignRedistribute, float rationalize_automateMl) {
		super();
		this.year = year;
		this.eliminate_reducdancyElimination = eliminate_reducdancyElimination;
		this.eliminate_retireDecommision = eliminate_retireDecommision;
		this.consolidate_realignRedistribute = consolidate_realignRedistribute;
		this.rationalize_automateMl = rationalize_automateMl;
	}
	
	public AssetClassificationHardwareYear()
	{
		
	}
	
}
