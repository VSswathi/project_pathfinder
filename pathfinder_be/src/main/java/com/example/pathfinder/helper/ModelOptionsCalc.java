package com.example.pathfinder.helper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.dto.TotalSavingsModel2BYear;

@Component
public class ModelOptionsCalc {
	
public TotalSavingsModel2BDto model2bcalculation(ItRunSpendDto run, SavingsOptimizationDto save,
		ItSpendOnRunPersonnelDto spend,TotalOutsourcingFitshoreDto fit) {
		
		TotalSavingsModel2BDto obj1= new TotalSavingsModel2BDto();
		obj1.setHardware_software_baseyear(run.getBaseLineYearSpend());
		obj1.setPersonnel_outsourcing_baseyear(spend.getItspend_baseline());
		obj1.setTotals_baseyear(obj1.getHardware_software_baseyear()+obj1.getPersonnel_outsourcing_baseyear());

		long total_baseline=obj1.getTotals_baseyear();
		long total_hardware_client_without_partner=0;
		long total_hardware_client_with_partner=0;
		long total_hardware_cost_reduction=0;
		
		long initial_hswop=0;
		long final_hswop=0;
		long initial_hswp=0;
		long final_hswp=0;
		long initial_hscr=0;
		long final_hscr=0;
		
		
		long total_personel_client_without_partner=0;
		long total_personel_client_with_partner=0;
		long total_personel_cost_reduction=0;
		
		long initial_powop=0;
		long final_powop=0;
		long initial_powp=0;
		long final_powp=0;
		long initial_pocr=0;
		long final_pocr=0;
		
		long sum_total_client_without_partner=0;
		long sum_total_client_with_partner=0;
		long sum_total_cost_reduction=0;
		
		long initial_twop=0;
		long final_twop=0;
		long initial_twp=0;
		long final_twp=0;
		long initial_tcr=0;
		long final_tcr=0;
		
		ArrayList<TotalSavingsModel2BYear> model2bcalc=new ArrayList<TotalSavingsModel2BYear>();
		

		 for(int i=1;i<=3;i++) {

			
			 TotalSavingsModel2BYear  obj2 = new TotalSavingsModel2BYear();
	            obj2.setYear(i);
	            obj2.setHardware_software_client_spend_without_partner((long) run.getRunCalc().get(i-1).getYearlyRunRate());
	            obj2.setHardware_software_client_spend_with_partner(save.getSavingsoptimizationcalculation().get(i-1).getRun_businessit());
	            obj2.setHardware_software_cost_reduction(obj2.getHardware_software_client_spend_without_partner()-obj2.getHardware_software_client_spend_with_partner());
	         

	            obj2.setPersonnel_outsourcing_client_spend_without_partner((long) spend.getRunpersonnelcalculation().get(i-1).getYearlyRunRate());
	            obj2.setPersonnel_outsourcing_client_spend_with_partner(fit.getOutsourceFitCalc().get(i-1).getTotoal_outsource_fit());
	            obj2.setPersonnel_outsourcing_cost_reduction(obj2.getPersonnel_outsourcing_client_spend_without_partner()-obj2.getPersonnel_outsourcing_client_spend_with_partner());
	            
	            obj2.setTotals_client_spend_without_partner(obj2.getPersonnel_outsourcing_client_spend_without_partner()+obj2.getHardware_software_client_spend_without_partner());
	            obj2.setTotals_client_spend_with_partner(obj2.getPersonnel_outsourcing_client_spend_with_partner()+obj2.getHardware_software_client_spend_with_partner());
	            obj2.setTotals_cost_reduction(obj2.getTotals_client_spend_without_partner()-obj2.getTotals_client_spend_with_partner());
	            
	            obj2.setCumulative_savings(obj2.getTotals_client_spend_with_partner()-total_baseline);
	            
	            
	            total_hardware_client_without_partner=obj2.getHardware_software_client_spend_without_partner();
	            final_hswop=(total_hardware_client_without_partner+initial_hswop); 
			    initial_hswop=final_hswop;
			    total_hardware_client_with_partner=obj2.getHardware_software_client_spend_with_partner();
	            final_hswp=(total_hardware_client_with_partner+initial_hswp); 
			    initial_hswp=final_hswp;
			    total_hardware_cost_reduction=obj2.getHardware_software_cost_reduction();
	            final_hscr=(total_hardware_cost_reduction+initial_hscr); 
			    initial_hscr=final_hscr;
			    
			    total_personel_client_without_partner=obj2.getPersonnel_outsourcing_client_spend_without_partner();
	            final_powop=(total_personel_client_without_partner+initial_powop); 
			    initial_powop=final_powop;
			    total_personel_client_with_partner=obj2.getPersonnel_outsourcing_client_spend_with_partner();
	            final_powp=(total_personel_client_with_partner+initial_powp); 
			    initial_powp=final_powp;
			    total_personel_cost_reduction=obj2.getPersonnel_outsourcing_cost_reduction();
	            final_pocr=(total_personel_cost_reduction+initial_pocr); 
			    initial_pocr=final_pocr;
			    
			    sum_total_client_without_partner=obj2.getTotals_client_spend_without_partner();
	            final_twop=(sum_total_client_without_partner+initial_twop); 
			    initial_twop=final_twop;
			    sum_total_client_with_partner=obj2.getTotals_client_spend_with_partner();
	            final_twp=(sum_total_client_with_partner+initial_twp); 
			    initial_twp=final_twp;
			    sum_total_cost_reduction=obj2.getTotals_cost_reduction();
	            final_tcr=(sum_total_cost_reduction+initial_tcr); 
			    initial_tcr=final_tcr;
			    
			    
			    
			    model2bcalc.add(obj2);
			
		}
		 
		 obj1.setTotal_hardware_software_client_spend_without_partner(final_hswop);
		 obj1.setTotal_hardware_software_client_spend_with_partner(final_hswp);
		 obj1.setTotal_hardware_software_cost_reduction(final_hscr);
		 obj1.setTotal_personnel_outsourcing_client_spend_without_partner(final_powop);
		 obj1.setTotal_personnel_outsourcing_client_spend_with_partner(final_powp);
		 obj1.setTotal_personnel_outsourcing_cost_reduction(final_pocr);
		 obj1.setSum_totals_client_spend_without_partner(final_twop);
		 obj1.setSum_totals_client_spend_with_partner(final_twp);
		 obj1.setSum_totals_cost_reduction(final_tcr);
		 
		 obj1.setModel2bcalculation(model2bcalc);		
		return obj1;
	}

}
