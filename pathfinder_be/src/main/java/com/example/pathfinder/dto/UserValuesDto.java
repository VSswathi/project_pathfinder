package com.example.pathfinder.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_new_user_values")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserValuesDto {

	
	@Id
	private String id;
	private AssetClassificationHardwareDto hardware;
	private AssetClassificationSoftwareDto software;
	private AssetClassificationManagedServicesDto managed;
	private AssetClassificationHostedCbsDto hostedcbs;
	private CostofTransformationDto cost;
	private InputTablesDto inputvalues;
	private ItFunctionsDto itfunctions;
	private ItPersonalCostDto itpersonalcost;
	private ItPersonnelDto itpersonnel;
	private ItSpendCategoriesDto itspendcat;
	
}