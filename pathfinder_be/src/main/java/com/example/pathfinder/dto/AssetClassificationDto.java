package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_total")
public class AssetClassificationDto {
	private String id;
	private long itspendonassets_baseline;
	ArrayList<ItSpendOnAssetsTotalYear> itspendcalc;

}
