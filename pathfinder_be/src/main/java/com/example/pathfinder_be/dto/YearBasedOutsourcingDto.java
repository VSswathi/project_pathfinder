package com.example.pathfinder_be.dto;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_year_based_outsourcing")
public class YearBasedOutsourcingDto {
	

	private int yearLine;
	private double takeOverPlan;
	private long infteCumulative;
	private double ppImprovement;
	private int fteSavingsCumulative;
	private long netPartnerFte;
	private double onsiteRatio;
	private long inFteOnsite;
	private double offshoreRatio;
	private long inFteOffshore;
	

}
