package com.example.pathfinder.dto;



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
	
	public YearBasedOutsourcingDto(int yearLine, double takeOverPlan, double ppImprovement, double onsiteRatio,
			double offshoreRatio) {
		super();
		this.yearLine = yearLine;
		this.takeOverPlan = takeOverPlan;
		this.ppImprovement = ppImprovement;
		this.onsiteRatio = onsiteRatio;
		this.offshoreRatio = offshoreRatio;
	}
	
	public YearBasedOutsourcingDto() {
		
	}
}
