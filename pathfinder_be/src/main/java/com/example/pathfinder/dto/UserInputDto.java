package com.example.pathfinder.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_user_input")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInputDto {

	
	@Id
	private String id;
	private String userId;
	private String projectName;
	private AssetClassificationDto asset;
	private AssetClassificationHardwareDto hardware;
	private AssetClassificationSoftwareDto software;
	private AssetClassificationManagedServicesDto managed;
	private AssetClassificationHostedCbsDto hostedcbs;
	private AssetOutsourceOnsiteDto outsourceonsite;
	private CostofTransformationDto cost;
	private InputTablesDto inputvalues;
	private ItFunctionsDto itfunctions;
	private ItPersonalCostDto itpersonalcost;
	private ItPersonnelDto itpersonnel;
	private ItPersonnelFitModelDto itpersfit;
	private ItRunSpendDto itrunspend;
	private ItSpendCategoriesDto itspendcat;
	private ItSpendOnRunPersonnelDto itspendrun;
	private RunItOutsourceCostsDto runitcost;
	private RunItOutsourceFteDto runitfte;
	private SavingsOptimizationDto savings;
	private TotalOutsourcingFitshoreDto totalfitshore;
	
	private RunOpexModelingFitshoreDto runopexfit;
	private RunOpexModelingOutsourceDto runopexoutsource;
	private RunOpexModelling2ADto model2A;
	private RunOpexModellingDto model2B;
	private TotalSavingsModel2ADto total2A;
	private TotalSavingsModel2BDto total2B;
	private WaterfallTableDto waterfall;
	
}