package com.example.pathfinder.dto;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_total")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetClassificationDto {
	private String id;
	private long itspendonassets_baseline;
	ArrayList<ItSpendOnAssetsTotalYear> itspendcalc;

}
