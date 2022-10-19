package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_personnel")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItPersonnelDto {
	
		private String id;
		private double it_spend_on_personal_perc;//67%
	    private long it_spend_outsource;//(it_spend_on_personal_perc*it_spent_value)
	    private long avr_ctc_per_fte;//150000  (input value)
	    private long avr_ctc_final;//(it_spent_outsource/avr_ctc_per_fte)
	    
	    private long run_fte_personal;//121613375  (run_business_perc*it_spend_outsourse)
	    private long run_fte_outsource;//(run_fte_personel/avr_ctc_per_fte)
	    
	    private long grow_fte_personal;//(grow_business_perc*it_spend_outsource)
	    private long grow_fte_outsource;//(grow_fte_personal/avr_ctc_per_fte)
	    
	    private long transform_fte_personal;//(transform_it_perc*it_spend_outsource)
	    private long transform_fte_outsource;//(transform_fte_personal/avr_ctc_per_fte)
	    
	    private double perc_eligible_forpersonal;//(input val) 85 %
	    private long  eligible_outsource;//(perc_eligible_forpersonal*run_fte_outsource)
	    

}
