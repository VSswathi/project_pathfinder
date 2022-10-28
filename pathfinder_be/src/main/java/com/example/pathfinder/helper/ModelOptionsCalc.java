package com.example.pathfinder.helper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunOpexModelingFitshoreDto;
import com.example.pathfinder.dto.RunOpexModelingFitshoreYear;
import com.example.pathfinder.dto.RunOpexModelingOutsourceDto;
import com.example.pathfinder.dto.RunOpexModelingOutsourceYear;
import com.example.pathfinder.dto.RunOpexModelling2ADto;
import com.example.pathfinder.dto.RunOpexModelling2AYear;
import com.example.pathfinder.dto.RunOpexModellingDto;
import com.example.pathfinder.dto.RunOpexModellingYear;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalSavingsModel2ADto;
import com.example.pathfinder.dto.TotalSavingsModel2AYear;
import com.example.pathfinder.dto.TotalSavingsModel2BDto;
import com.example.pathfinder.dto.TotalSavingsModel2BYear;

@Component
public class ModelOptionsCalc {
	
// 20-pathfinder_total_savings_model2b
	
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
		
			 int i=run.getRunCalc().size();
				for(int k=0;k<i;k++) {
			
			 TotalSavingsModel2BYear  obj2 = new TotalSavingsModel2BYear();
	            obj2.setYear(k+1);
	            obj2.setHardware_software_client_spend_without_partner((long) run.getRunCalc().get(k).getYearlyRunRate());
	            obj2.setHardware_software_client_spend_with_partner(save.getSavingsoptimizationcalculation().get(k).getRun_businessit());
	            obj2.setHardware_software_cost_reduction(obj2.getHardware_software_client_spend_without_partner()-obj2.getHardware_software_client_spend_with_partner());
	         

	            obj2.setPersonnel_outsourcing_client_spend_without_partner((long) spend.getRunpersonnelcalculation().get(k).getYearlyRunRate());
	            obj2.setPersonnel_outsourcing_client_spend_with_partner(fit.getOutsourceFitCalc().get(k).getTotoal_outsource_fit());
	            obj2.setPersonnel_outsourcing_cost_reduction(obj2.getPersonnel_outsourcing_client_spend_without_partner()-obj2.getPersonnel_outsourcing_client_spend_with_partner());
	            
	            obj2.setTotals_client_spend_without_partner(obj2.getPersonnel_outsourcing_client_spend_without_partner()+obj2.getHardware_software_client_spend_without_partner());
	            obj2.setTotals_client_spend_with_partner(obj2.getPersonnel_outsourcing_client_spend_with_partner()+obj2.getHardware_software_client_spend_with_partner());
	            obj2.setTotals_cost_reduction(obj2.getTotals_client_spend_without_partner()-obj2.getTotals_client_spend_with_partner());
	            
	            obj2.setCumulative_savings(Math.abs(obj2.getTotals_client_spend_with_partner()-total_baseline));
	            
	            
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



// 21-pathfinder_run_opex_fit_shore

	public RunOpexModelingFitshoreDto runfit_calculation(TotalSavingsModel2BDto model) {
		
		RunOpexModelingFitshoreDto obj1= new RunOpexModelingFitshoreDto();
		
		obj1.setClient_drives_baseyear(model.getTotals_baseyear());
		obj1.setWith_partner_hs_baseyear(obj1.getClient_drives_baseyear());
		obj1.setWith_partner_personnel_baseyear(obj1.getClient_drives_baseyear());
		obj1.setTotal_partner_baseyear(obj1.getWith_partner_personnel_baseyear());
		
		long total_client_drives=0;
		long total_with_phs=0;
		long total_with_pp=0;
			
		long initial_client=0;
		long final_client=0;
		long initial_with_phs=0;
		long final_with_phs=0;
		long initial_with_pp=0;
		long final_with_pp=0;
		
		ArrayList<RunOpexModelingFitshoreYear> runfitcalc=new ArrayList<RunOpexModelingFitshoreYear>();
		

			 int i=model.getModel2bcalculation().size();
				for(int k=0;k<i;k++) {
			
			 	RunOpexModelingFitshoreYear  obj2 = new RunOpexModelingFitshoreYear();
	            obj2.setYear(k+1);
	            obj2.setClient_drives(model.getModel2bcalculation().get(k).getTotals_client_spend_without_partner());
	            obj2.setWith_partner_hs(model.getModel2bcalculation().get(k).getHardware_software_client_spend_with_partner()+model.getModel2bcalculation().get(k).getPersonnel_outsourcing_client_spend_without_partner());
	            obj2.setWith_partner_personnel(model.getModel2bcalculation().get(k).getPersonnel_outsourcing_client_spend_with_partner()+model.getModel2bcalculation().get(k).getHardware_software_client_spend_without_partner());
	            obj2.setTotal_partner(model.getModel2bcalculation().get(k).getTotals_client_spend_with_partner());
	            
	            total_client_drives=obj2.getClient_drives();
	            final_client=(total_client_drives+initial_client);
	            initial_client=final_client;
	            total_with_phs=obj2.getWith_partner_hs();
	            final_with_phs=(total_with_phs+initial_with_phs);
	            initial_with_phs=final_with_phs;
	            total_with_pp=obj2.getWith_partner_personnel();
	            final_with_pp=(total_with_pp+initial_with_pp);
	            initial_with_pp=final_with_pp;
	            
			    runfitcalc.add(obj2);
			
		}
		 
		 obj1.setTotal_client_drives(final_client);
		 obj1.setTotal_with_partner_hs(final_with_phs);
		 obj1.setTotal_with_partner_personnel(final_with_pp);
		 obj1.setSum_total_partner(model.getSum_totals_client_spend_with_partner());
		 obj1.setWith_partner_hs_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_hs());
		 obj1.setWith_partner_personnel_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_personnel());
		 obj1.setTotal_partner_cumulative(obj1.getTotal_client_drives()-obj1.getSum_total_partner());
		 
		 obj1.setRunfitshorecalculation(runfitcalc);
		 
		return obj1;
	}



// 22-pathfinder_run_opex_modelling

	public RunOpexModellingDto runopex_calculation(RunOpexModelingFitshoreDto fit) {
	
	RunOpexModellingDto obj1= new RunOpexModellingDto();
	
	obj1.setClient_drives_baseyear(fit.getClient_drives_baseyear()/1000000);
	obj1.setWith_partner_hs_baseyear(fit.getWith_partner_hs_baseyear()/1000000);
	obj1.setWith_partner_personnel_baseyear(fit.getWith_partner_personnel_baseyear()/1000000);
	obj1.setTotal_partner_baseyear(fit.getTotal_partner_baseyear()/1000000);
	
	ArrayList<RunOpexModellingYear> runopexcalculation=new ArrayList<RunOpexModellingYear>();
	
	 int i=fit.getRunfitshorecalculation().size();
		for(int k=0;k<i;k++) {
		
		 	RunOpexModellingYear  obj2 = new RunOpexModellingYear();
            obj2.setYear(k+1);
            obj2.setClient_drives(fit.getRunfitshorecalculation().get(k).getClient_drives()/1000000);
            obj2.setWith_partner_hs(fit.getRunfitshorecalculation().get(k).getWith_partner_hs()/1000000);
            obj2.setWith_partner_personnel(fit.getRunfitshorecalculation().get(k).getWith_partner_personnel()/1000000);
            obj2.setTotal_partner(fit.getRunfitshorecalculation().get(k).getTotal_partner()/1000000);
         
            runopexcalculation.add(obj2);
		
	}
		
	 
	 obj1.setTotal_client_drives(fit.getTotal_client_drives()/1000000);
	 obj1.setTotal_with_partner_hs(fit.getTotal_with_partner_hs()/1000000);
	 obj1.setTotal_with_partner_personnel(fit.getTotal_with_partner_personnel()/1000000);
	 obj1.setSum_total_partner(fit.getSum_total_partner()/1000000);
	 obj1.setWith_partner_hs_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_hs());
	 obj1.setWith_partner_personnel_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_personnel());
	 obj1.setTotal_partner_cumulative(obj1.getTotal_client_drives()-obj1.getSum_total_partner());
	 
	 float with_phsc_perc=(float)obj1.getWith_partner_hs_cumulative()*100f;
	 
	 obj1.setWith_partner_hs_cumulative_perc(Math.round(with_phsc_perc/obj1.getTotal_client_drives()));
	 obj1.setWith_partner_personnel_cumulative_perc(Math.round((float)(obj1.getWith_partner_personnel_cumulative()*100f)/obj1.getTotal_client_drives()));
	 obj1.setTotal_partner_cumulative_perc(Math.round((float)(obj1.getTotal_partner_cumulative()*100f)/obj1.getTotal_client_drives()));
	 
	 	 
	 obj1.setRunOpexCalc(runopexcalculation);
	 
	return obj1;
}


// 23-pathfinder_total_savings_model2a

	public TotalSavingsModel2ADto model2a_calculation(ItRunSpendDto run, SavingsOptimizationDto save,
		ItSpendOnRunPersonnelDto spend,AssetOutsourceOnsiteDto asset,TotalSavingsModel2BDto model) {
		
		TotalSavingsModel2ADto obj1= new TotalSavingsModel2ADto();
		obj1.setHardware_software_baseyear(run.getBaseLineYearSpend());
		obj1.setPersonnel_outsourcing_baseyear(spend.getItspend_baseline());
		obj1.setTotals_baseyear(obj1.getHardware_software_baseyear()+obj1.getPersonnel_outsourcing_baseyear());

		
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
		
		ArrayList<TotalSavingsModel2AYear> model2acalc=new ArrayList<TotalSavingsModel2AYear>();
		
		 int i=run.getRunCalc().size();
			for(int k=0;k<i;k++) {
			
			 TotalSavingsModel2AYear  obj2 = new TotalSavingsModel2AYear();
	            obj2.setYear(k+1);
	            obj2.setHardware_software_client_spend_without_partner((long) run.getRunCalc().get(k).getYearlyRunRate());
	            obj2.setHardware_software_client_spend_with_partner(save.getSavingsoptimizationcalculation().get(k).getRun_businessit());
	            obj2.setHardware_software_cost_reduction(obj2.getHardware_software_client_spend_without_partner()-obj2.getHardware_software_client_spend_with_partner());
	         

	            obj2.setPersonnel_outsourcing_client_spend_without_partner((long) spend.getRunpersonnelcalculation().get(k).getYearlyRunRate());
	            obj2.setPersonnel_outsourcing_client_spend_with_partner(asset.getOutsourceOnsiteCalc().get(k).getOutsource_onsite_only());
	            obj2.setPersonnel_outsourcing_cost_reduction(obj2.getPersonnel_outsourcing_client_spend_without_partner()-obj2.getPersonnel_outsourcing_client_spend_with_partner());
	            
	            obj2.setTotals_client_spend_without_partner(obj2.getPersonnel_outsourcing_client_spend_without_partner()+obj2.getHardware_software_client_spend_without_partner());
	            obj2.setTotals_client_spend_with_partner(obj2.getPersonnel_outsourcing_client_spend_with_partner()+obj2.getHardware_software_client_spend_with_partner());
	            obj2.setTotals_cost_reduction(Math.abs(obj2.getTotals_client_spend_without_partner()-obj2.getTotals_client_spend_with_partner()));
	            
	            obj2.setCumulative_savings(Math.abs(obj2.getTotals_client_spend_with_partner()-model.getTotals_baseyear()));
	            
	            
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
			    
			    
			    
			    model2acalc.add(obj2);
			
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
		 
		 obj1.setModel2acalculation(model2acalc);		
		return obj1;
	}
	

// 24-pathfinder_run_opex_outsource

	public RunOpexModelingOutsourceDto runoutsource_calculation(TotalSavingsModel2ADto modela,TotalSavingsModel2BDto modelb) {
	
	RunOpexModelingOutsourceDto obj1= new RunOpexModelingOutsourceDto();
	
	obj1.setClient_drives_baseyear(modelb.getTotals_baseyear());
	obj1.setWith_partner_hs_baseyear(obj1.getClient_drives_baseyear());
	obj1.setWith_partner_personnel_baseyear(obj1.getClient_drives_baseyear());
	obj1.setTotal_partner_baseyear(obj1.getWith_partner_personnel_baseyear());
	
	long total_client_drives=0;
	long total_with_phs=0;
	long total_with_pp=0;
		
	long initial_client=0;
	long final_client=0;
	long initial_with_phs=0;
	long final_with_phs=0;
	long initial_with_pp=0;
	long final_with_pp=0;
	
	ArrayList<RunOpexModelingOutsourceYear> runoutsourcecalc=new ArrayList<RunOpexModelingOutsourceYear>();

	 int i=modela.getModel2acalculation().size();
		for(int k=0;k<i;k++) {
		
		 	RunOpexModelingOutsourceYear  obj2 = new RunOpexModelingOutsourceYear();
            obj2.setYear(k+1);
            obj2.setClient_drives(modela.getModel2acalculation().get(k).getTotals_client_spend_without_partner());
            obj2.setWith_partner_hs(modela.getModel2acalculation().get(k).getHardware_software_client_spend_with_partner()+modela.getModel2acalculation().get(k).getPersonnel_outsourcing_client_spend_without_partner());
            obj2.setWith_partner_personnel(modela.getModel2acalculation().get(k).getPersonnel_outsourcing_client_spend_with_partner()+modela.getModel2acalculation().get(k).getHardware_software_client_spend_without_partner());
            obj2.setTotal_partner(modela.getModel2acalculation().get(k).getTotals_client_spend_with_partner());
            
            total_client_drives=obj2.getClient_drives();
            final_client=(total_client_drives+initial_client);
            initial_client=final_client;
            total_with_phs=obj2.getWith_partner_hs();
            final_with_phs=(total_with_phs+initial_with_phs);
            initial_with_phs=final_with_phs;
            total_with_pp=obj2.getWith_partner_personnel();
            final_with_pp=(total_with_pp+initial_with_pp);
            initial_with_pp=final_with_pp;
            
            runoutsourcecalc.add(obj2);
		
	}
	 
	 obj1.setTotal_client_drives(final_client);
	 obj1.setTotal_with_partner_hs(final_with_phs);
	 obj1.setTotal_with_partner_personnel(final_with_pp);
	 obj1.setSum_total_partner(modela.getSum_totals_client_spend_with_partner());
	 obj1.setWith_partner_hs_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_hs());
	 obj1.setWith_partner_personnel_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_personnel());
	 obj1.setTotal_partner_cumulative(obj1.getTotal_client_drives()-obj1.getSum_total_partner());
	 
	 obj1.setRunoutsourcecalculation(runoutsourcecalc);
	 
	return obj1;
}

	
// 25-pathfinder_run_opex_model2a
	
	public RunOpexModelling2ADto runopex2a_calculation(RunOpexModelingOutsourceDto out) {
	
	RunOpexModelling2ADto obj1= new RunOpexModelling2ADto();
	
	obj1.setClient_drives_baseyear(out.getClient_drives_baseyear()/1000000);
	obj1.setWith_partner_hs_baseyear(out.getWith_partner_hs_baseyear()/1000000);
	obj1.setWith_partner_personnel_baseyear(out.getWith_partner_personnel_baseyear()/1000000);
	obj1.setTotal_partner_baseyear(out.getTotal_partner_baseyear()/1000000);
	
	ArrayList<RunOpexModelling2AYear> runopex2acalculation=new ArrayList<RunOpexModelling2AYear>();
	
	int i=out.getRunoutsourcecalculation().size();
	for(int k=0;k<i;k++) {
		
		 	RunOpexModelling2AYear  obj2 = new RunOpexModelling2AYear();
            obj2.setYear(k+1);
            obj2.setClient_drives(out.getRunoutsourcecalculation().get(k).getClient_drives()/1000000);
            obj2.setWith_partner_hs(out.getRunoutsourcecalculation().get(k).getWith_partner_hs()/1000000);
            obj2.setWith_partner_personnel(out.getRunoutsourcecalculation().get(k).getWith_partner_personnel()/1000000);
            obj2.setTotal_partner(out.getRunoutsourcecalculation().get(k).getTotal_partner()/1000000);
         
            runopex2acalculation.add(obj2);
		
	}
	 
	 obj1.setTotal_client_drives(out.getTotal_client_drives()/1000000);
	 obj1.setTotal_with_partner_hs(out.getTotal_with_partner_hs()/1000000);
	 obj1.setTotal_with_partner_personnel(out.getTotal_with_partner_personnel()/1000000);
	 obj1.setSum_total_partner(out.getSum_total_partner()/1000000);
	 obj1.setWith_partner_hs_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_hs());
	 obj1.setWith_partner_personnel_cumulative(obj1.getTotal_client_drives()-obj1.getTotal_with_partner_personnel());
	 obj1.setTotal_partner_cumulative(obj1.getTotal_client_drives()-obj1.getSum_total_partner());
	 
	 obj1.setWith_partner_hs_cumulative_perc(Math.round((float)(obj1.getWith_partner_hs_cumulative()*100f)/obj1.getTotal_client_drives()));
	 obj1.setWith_partner_personnel_cumulative_perc(Math.round((float)(obj1.getWith_partner_personnel_cumulative()*100f)/obj1.getTotal_client_drives()));
	 obj1.setTotal_partner_cumulative_perc(Math.round((float)(obj1.getTotal_partner_cumulative()*100f)/obj1.getTotal_client_drives()));
	 
	 	 
	 obj1.setRunOpex2aCalculation(runopex2acalculation);
	 
	return obj1;
}



}
