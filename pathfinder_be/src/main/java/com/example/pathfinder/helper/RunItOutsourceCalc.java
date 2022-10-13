package com.example.pathfinder.helper;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.AssetOutsourceOnsiteDto;
import com.example.pathfinder.dto.AssetOutsourceOnsiteYear;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItPersonnelFitModelDto;
import com.example.pathfinder.dto.ItPersonnelFitModelYear;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.RunItOutsourceCostsDto;
import com.example.pathfinder.dto.RunItOutsourceCostsYear;
import com.example.pathfinder.dto.RunItOutsourceFteDto;
import com.example.pathfinder.dto.RunItOutsourceFteYear;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreDto;
import com.example.pathfinder.dto.TotalOutsourcingFitshoreYear;

@Component

public class RunItOutsourceCalc {
	
//Run It Personnel with 85% Outsourcing (FTE)
public RunItOutsourceFteDto runfteCalc( InputTablesDto inp,ItPersonnelDto itp,ItPersonalCostDto ipc) {
	    
	    RunItOutsourceFteDto obj=new RunItOutsourceFteDto();
        
       obj.setClient_exist_baseyear((int) (itp.getRun_fte_outsource()));
       obj.setPartner_exist_baseyear(0);
       obj.setNet_fte_scope_baseyear(obj.getClient_exist_baseyear()+obj.getPartner_exist_baseyear());
    
       
       
        ArrayList<RunItOutsourceFteYear> yrBasedCalc=new ArrayList<RunItOutsourceFteYear>();
      
        int client_base=obj.getClient_exist_baseyear();
        int netfteoriginal=0;
        int netfte_baseyear=obj.getNet_fte_scope_baseyear();
            
        for(int i=1;i<=3;i++) {
        	RunItOutsourceFteYear  a = new RunItOutsourceFteYear();
            a.setYear(i);
            double take_over_plan_perc= ipc.getYearBseCalculations().get(i-1).getTakeOverPlan()/100;
            
                a.setRun_it_outsource((int) ( take_over_plan_perc*itp.getEligible_outsource()));
                a.setClient_exit_load(client_base-a.getRun_it_outsource());
                client_base=a.getClient_exit_load();
                
                a.setPartner_exit_load((int) ipc.getYearBseCalculations().get(i-1).getNetPartnerFte());
                a.setNet_fte_original((short) (a.getClient_exit_load()+a.getPartner_exit_load()));

                netfteoriginal=a.getNet_fte_original();
            yrBasedCalc.add(a);
    }
       
        obj.setTotal_savings_in_fte(netfte_baseyear-netfteoriginal);
	    obj.setRunfteCalc(yrBasedCalc);
        return obj;
    
    }

//Run It Personnel with 85% Outsourcing (Costs)

public RunItOutsourceCostsDto runCostsCalc( InputTablesDto inp,ItPersonnelDto itp,ItPersonalCostDto ipc, RunItOutsourceFteDto fte) {
    
    RunItOutsourceCostsDto obj=new RunItOutsourceCostsDto();
    
   obj.setClient_spend_baseyear((int) (fte.getClient_exist_baseyear()*itp.getAvr_ctc_per_fte()));
   obj.setPartner_bill_baseyear(0);
   obj.setTotal_spend_baseyear(obj.getClient_spend_baseyear()+obj.getPartner_bill_baseyear());

   
   
    ArrayList<RunItOutsourceCostsYear> yrCalc=new ArrayList<RunItOutsourceCostsYear>();
  
    double initial_client=0;
    double initial_partner=0;
    double initial_total_spend=0;
        
    for(int i=1;i<=3;i++) {
    	RunItOutsourceCostsYear  a = new RunItOutsourceCostsYear();
        a.setYear(i);
        
       double annual_inflation = inp.getAnnual_inflation_perc()/100;
       
       a.setClient_spend((int) ( (fte.getRunfteCalc().get(i-1).getClient_exit_load()*itp.getAvr_ctc_per_fte())+(annual_inflation*(fte.getRunfteCalc().get(i-1).getClient_exit_load()*itp.getAvr_ctc_per_fte()))));
       a.setPartner_bill((int) ((fte.getRunfteCalc().get(i-1).getPartner_exit_load()*ipc.getPartnerCtcOnsite())+(annual_inflation*((fte.getRunfteCalc().get(i-1).getPartner_exit_load()*ipc.getPartnerCtcOnsite())))));            
        a.setTotal_spend(a.getClient_spend()+a.getPartner_bill());  
        
        initial_client=a.getClient_spend();
        initial_partner=a.getPartner_bill();
        initial_total_spend=a.getTotal_spend();
           
        yrCalc.add(a);
}
   obj.setTotal_client_spend((int) initial_client);
   obj.setTotal_partner_bill_spend((int) initial_partner);
   obj.setTotal_sum_spend((int) initial_total_spend);
   
    obj.setRunCostsCalc(yrCalc);
    return obj;

}

//It Personnel Fit-Shoring Model
public ItPersonnelFitModelDto personnelFitCalc( InputTablesDto inp,ItPersonalCostDto ipc, RunItOutsourceFteDto fte, RunItOutsourceCostsDto cost) {

ItPersonnelFitModelDto obj=new ItPersonnelFitModelDto();

obj.setPartner_fte_baseyear(obj.getFte_onsite_baseyear()+obj.getFte_offshore_baseyear());
obj.setPartner_bill_baseyear(obj.getBill_onsite_baseyear()+obj.getBill_offshore_baseyear());
obj.setClient_baseyear(fte.getClient_exist_baseyear());
obj.setClient_fte_baseyear(cost.getClient_spend_baseyear());
obj.setTotal_spend_baseyear(obj.getClient_fte_baseyear()+obj.getPartner_fte_baseyear());

ArrayList<ItPersonnelFitModelYear> yrCalc=new ArrayList<ItPersonnelFitModelYear>();

long total_partner=0;
long total_sum_spend=0;
long partner_bill_total=0;
long total_spend_original=0;

for(int i=1;i<=3;i++) {
	ItPersonnelFitModelYear  a = new ItPersonnelFitModelYear();
    a.setYear(i);
    
   double annual_inflation = inp.getAnnual_inflation_perc()/100;
   
   a.setClient_year(fte.getRunfteCalc().get(i-1).getClient_exit_load());
   a.setClient_fte_year(cost.getRunCostsCalc().get(i-1).getClient_spend());
   
   a.setFte_onsite((int) ipc.getYearBseCalculations().get(i-1).getInFteOnsite());
   a.setFte_offshore((int) ipc.getYearBseCalculations().get(i-1).getInFteOffshore());
   a.setPartner_fte_total(a.getFte_onsite()+a.getFte_offshore());
   
   a.setBill_onsite((long) ((a.getFte_onsite()*ipc.getPartnerCtcOnsite())+(annual_inflation*(a.getFte_onsite()*ipc.getPartnerCtcOnsite()))));
   a.setBill_offshore((long) ((a.getFte_offshore()*ipc.getPartnerCtcOffshore())+(annual_inflation*(a.getFte_offshore()*ipc.getPartnerCtcOffshore()))));
   a.setPartner_bill_total(a.getBill_onsite()+a.getBill_offshore());
   
   
   a.setTotal_spend_for_original(a.getClient_fte_year()+a.getPartner_bill_total());

   partner_bill_total=a.getPartner_bill_total()+total_partner;
   total_partner=partner_bill_total;
   total_spend_original=a.getTotal_spend_for_original()+total_sum_spend;
   total_sum_spend=total_spend_original;
     
    yrCalc.add(a);
}
obj.setTotal_partner(total_partner);
obj.setTotal_sum_spend(total_sum_spend);


obj.setFitcalc(yrCalc);
return obj;

}

//Asset Outsourcing Onsite Only
public AssetOutsourceOnsiteDto outsourceOnsiteCalc(ItPersonnelDto itp, CostofTransformationDto cot,ItSpendOnRunPersonnelDto irp, RunItOutsourceCostsDto cost) {

	AssetOutsourceOnsiteDto obj=new AssetOutsourceOnsiteDto();

ArrayList<AssetOutsourceOnsiteYear> yrCalc=new ArrayList<AssetOutsourceOnsiteYear>();

long total_itspend=0;
long sum_total_itspend=0;
long sum_cot_partner_share=0;
long total_cot_partner_share=0;
long sum_total_savings_yoy=0;
long total_savings_yoy=0;
long sum_total_outsource_onsite_only=0;
long total_outsource_onsite_only=0;

for(int i=1;i<=3;i++) {
	AssetOutsourceOnsiteYear  a = new AssetOutsourceOnsiteYear();
    a.setYear(i);
    
   double itspend_percentage=itp.getIt_spend_on_personal_perc()/100;
   
   a.setTotal_it_spend(cost.getRunCostsCalc().get(i-1).getTotal_spend());
   a.setCot_partner_share((long) (itspend_percentage*cot.getYearBaseCostCalculations().get(i-1).getPartner_share_value()));
   a.setTotal_savings_yoy((long) (a.getCot_partner_share()+(irp.getRunpersonnelcalculation().get(i-1).getYearlyRunRate()-a.getTotal_it_spend())));
   a.setOutsource_onsite_only(a.getTotal_it_spend()-a.getCot_partner_share());

   sum_total_itspend=a.getTotal_it_spend()+total_itspend;
   total_itspend=sum_total_itspend;
 
   sum_cot_partner_share=a.getCot_partner_share()+total_cot_partner_share;
   total_cot_partner_share=sum_cot_partner_share; 
   
   sum_total_savings_yoy=a.getTotal_savings_yoy()+total_savings_yoy;
   total_savings_yoy=sum_total_savings_yoy;
   
   sum_total_outsource_onsite_only=a.getOutsource_onsite_only()+total_outsource_onsite_only;
   total_outsource_onsite_only=sum_total_outsource_onsite_only;
    yrCalc.add(a);
}

obj.setSum_total_it_spend(total_itspend);
obj.setSum_cot_partner_share(total_cot_partner_share);
obj.setSum_total_savings_yoy(total_savings_yoy);
obj.setSum_outsource_onsite_only(total_outsource_onsite_only);

float main_value=obj.getSum_total_savings_yoy()*100;
obj.setMain_total_savings_yoy(Math.round(main_value/irp.getTotal_itSpendWithInflation()));

obj.setOutsourceOnsiteCalc(yrCalc);
return obj;

}

//Total Outsourcing/Fitshore
public TotalOutsourcingFitshoreDto outsourceFitCalc(ItPersonnelDto itp, CostofTransformationDto cot, ItPersonnelFitModelDto ipf, ItSpendOnRunPersonnelDto run) {
    
	TotalOutsourcingFitshoreDto obj=new TotalOutsourcingFitshoreDto();
   
    ArrayList<TotalOutsourcingFitshoreYear> yrCalc=new ArrayList<TotalOutsourcingFitshoreYear>();
  
    long sum_total_onsite=0;
    long total_onsite=0;
    long sum_cot_partner=0;
    long cot_partner=0;
    long sum_total_outsource=0;
    long total_outsource=0;
    long total_yoy=0;
    long sum_total_yoy=0;
    
    for(int i=1;i<=3;i++) {
    	TotalOutsourcingFitshoreYear  a = new TotalOutsourcingFitshoreYear();
        a.setYear(i);
        
       double it_spend_on_personnel_perc = itp.getIt_spend_on_personal_perc()/100;
        
        a.setOnsite_offshore_model(ipf.getFitcalc().get(i-1).getTotal_spend_for_original());
        a.setCot_partner_share((long) (it_spend_on_personnel_perc*cot.getYearBaseCostCalculations().get(i-1).getPartner_share_value()));
        a.setTotoal_outsource_fit(a.getOnsite_offshore_model()-a.getCot_partner_share());
        
        a.setTotal_savings_yoy((long) (a.getCot_partner_share()+(run.getRunpersonnelcalculation().get(i-1).getYearlyRunRate()-a.getOnsite_offshore_model())));
        
    total_onsite=a.getOnsite_offshore_model()+sum_total_onsite;
    sum_total_onsite=total_onsite;
    
    cot_partner=a.getCot_partner_share()+sum_cot_partner;
    sum_cot_partner=cot_partner;
    
    total_outsource=a.getTotoal_outsource_fit()+sum_total_outsource;
    sum_total_outsource=total_outsource;
    
    total_yoy=a.getTotal_savings_yoy()+sum_total_yoy;
    sum_total_yoy=total_yoy;
         
        yrCalc.add(a);
}
    obj.setSum_onsite_offshore_model(sum_total_onsite);
    obj.setSum_cot_partner_share(sum_cot_partner);
    obj.setSum_totoal_outsource_fit(total_outsource);
    obj.setSum_total_savings_yoy(sum_total_yoy);

   float main_value=obj.getSum_total_savings_yoy()*100;
   obj.setMain_total_savings_yoy(Math.round(main_value/run.getTotal_itSpendWithInflation()));
   
   obj.setOutsourceFitCalc(yrCalc);
    return obj;

}
}
