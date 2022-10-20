package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_personnel")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItPersonnelDto {
	
		private String id;
		private double it_spend_on_personal_perc;
	    private long it_spend_outsource;
	    private long avr_ctc_per_fte;
	    private long avr_ctc_final;
	    
	    private long run_fte_personal;
	    private long run_fte_outsource;
	    
	    private long grow_fte_personal;
	    private long grow_fte_outsource;
	    
	    private long transform_fte_personal;
	    private long transform_fte_outsource;
	    
	    private double perc_eligible_forpersonal;
	    private long  eligible_outsource;
		public ItPersonnelDto(double it_spend_on_personal_perc, long avr_ctc_per_fte,
				double perc_eligible_forpersonal) {
			super();
			this.it_spend_on_personal_perc = it_spend_on_personal_perc;
			this.avr_ctc_per_fte = avr_ctc_per_fte;
			this.perc_eligible_forpersonal = perc_eligible_forpersonal;
		}
	    
		public ItPersonnelDto() {
			
		}
}
