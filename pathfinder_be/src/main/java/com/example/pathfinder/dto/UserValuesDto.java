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
	public UserValuesDto(AssetClassificationHardwareDto hardware, AssetClassificationSoftwareDto software,
			AssetClassificationManagedServicesDto managed, AssetClassificationHostedCbsDto hostedcbs,
			CostofTransformationDto cost, InputTablesDto inputvalues, ItFunctionsDto itfunctions,
			ItPersonalCostDto itpersonalcost, ItPersonnelDto itpersonnel, ItSpendCategoriesDto itspendcat) {
		super();
		this.hardware = hardware;
		this.software = software;
		this.managed = managed;
		this.hostedcbs = hostedcbs;
		this.cost = cost;
		this.inputvalues = inputvalues;
		this.itfunctions = itfunctions;
		this.itpersonalcost = itpersonalcost;
		this.itpersonnel = itpersonnel;
		this.itspendcat = itspendcat;
	}
	private ItPersonalCostDto itpersonalcost;
	private ItPersonnelDto itpersonnel;
	private ItSpendCategoriesDto itspendcat;
	
	public UserValuesDto() {
		
	}
}