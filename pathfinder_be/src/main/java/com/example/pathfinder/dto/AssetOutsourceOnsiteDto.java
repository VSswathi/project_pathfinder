package com.example.pathfinder.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_asset_outsource_onsite")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetOutsourceOnsiteDto {
	
	private List<AssetOutsourceOnsiteYear> outsourceOnsiteCalc;
	private String id;
	private long sum_total_it_spend;
	private long sum_cot_partner_share;
	private long sum_outsource_onsite_only;
	private long sum_total_savings_yoy;
	
	private float main_total_savings_yoy;	
}
