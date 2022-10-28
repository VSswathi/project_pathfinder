package com.example.pathfinder.helper;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.dto.WaterfallTableDto;

@Component
public class WaterfallCalc {

	
//	26-pathfinder_waterfall_table
	
	public WaterfallTableDto calculateValue( TotalSavingsModel2BDto modelb, TotalSavingsModel2ADto modela) {
		WaterfallTableDto obj= new WaterfallTableDto();
		
		obj.setBaseyear_with_partner(modelb.getTotals_baseyear());
		obj.setBaseyear_without_partner(obj.getBaseyear_with_partner());
		obj.setYear1_with_partner(modelb.getModel2bcalculation().get(0).getTotals_client_spend_with_partner()-modelb.getTotals_baseyear());
		obj.setYear1_without_partner(modelb.getModel2bcalculation().get(0).getTotals_client_spend_without_partner());
		obj.setYear2_with_partner(modelb.getModel2bcalculation().get(1).getTotals_client_spend_with_partner()-modelb.getModel2bcalculation().get(0).getTotals_client_spend_with_partner());
		obj.setYear2_without_partner(modelb.getModel2bcalculation().get(1).getTotals_client_spend_without_partner()-modelb.getModel2bcalculation().get(0).getTotals_client_spend_without_partner());
		obj.setYear3_with_partner(modelb.getModel2bcalculation().get(2).getTotals_client_spend_with_partner()-modelb.getModel2bcalculation().get(1).getTotals_client_spend_with_partner());
		obj.setYear3_without_partner(modelb.getModel2bcalculation().get(2).getTotals_client_spend_without_partner()-modelb.getModel2bcalculation().get(1).getTotals_client_spend_without_partner());
		
		obj.setExit_runrate_with_partner(modelb.getModel2bcalculation().get(2).getTotals_client_spend_with_partner());
		obj.setExit_runrate_without_partner(modela.getModel2acalculation().get(2).getTotals_client_spend_without_partner());
		
		obj.setRunrate_reduc_with_partner(obj.getExit_runrate_with_partner()-obj.getBaseyear_with_partner());
		obj.setRunrate_perc_without_partner(obj.getExit_runrate_without_partner()-obj.getBaseyear_without_partner());
		obj.setRunrate_perc_with_partner(obj.getRunrate_perc_with_partner()/obj.getBaseyear_with_partner());
		obj.setRunrate_perc_without_partner(obj.getRunrate_reduc_without_partner()/obj.getBaseyear_without_partner());
		obj.setCumulative_savings_with_partner(modelb.getSum_totals_cost_reduction());
		
		return obj;
	}
}
