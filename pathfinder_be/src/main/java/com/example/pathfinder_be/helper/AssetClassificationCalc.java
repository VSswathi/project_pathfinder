package com.example.pathfinder_be.helper;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pathfinder_be.dto.AssetClassificationDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareYear;
import com.example.pathfinder_be.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder_be.dto.AssetClassificationHostedCbsYear;
import com.example.pathfinder_be.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder_be.dto.AssetClassificationManagedServicesYear;
import com.example.pathfinder_be.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder_be.dto.AssetClassificationSoftwareYear;
import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.dto.ItRunYearlyDto;
import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.dto.ItSpendOnAssetsTotalYear;
import com.example.pathfinder_be.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder_be.dto.ItSpendOnRunPersonnelYear;
import com.example.pathfinder_be.dto.SavingsOptimizationDto;
import com.example.pathfinder_be.dto.SavingsOptimizationYear;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.YearBasedOutsourcingDto;
import com.example.pathfinder_be.dto.YearBasedTransformationDto;
import com.example.pathfinder_be.repo.CostofTransformationRepo;

@Component
public class AssetClassificationCalc {

	@Autowired
	CostofTransformationRepo cotRepo;

//It Run Spend without It Personnel
	
	public ItRunSpendDto yearBasedCalculation(ItPersonnelDto itp, InputTablesDto inp, CostofTransformationDto cot) {
	    
        ItRunSpendDto obj=new ItRunSpendDto();
        double itspendonpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
        double annualinflationpercentage=inp.getAnnual_inflation_perc()/100;
        
       obj.setBaseLineYearSpend((long) (inp.getRun_business_value()-(itspendonpersonalpercentage*inp.getRun_business_value())));
    
       
       
        ArrayList<ItRunYearlyDto> yrBasedCalc=new ArrayList<ItRunYearlyDto>();
      
        long secondyear=0;
        long itspent_with_inflation_total=0;
        long cost_of_transformation_clint_total=0;
        long yearly_run_rate_total=0;
        
            
        for(int i=1;i<=3;i++) {
            ItRunYearlyDto  a = new ItRunYearlyDto();
            a.setYear(i);
            if(i==1) {
                
                a.setItSpendWithInflation((long) Math.round(obj.getBaseLineYearSpend()+(annualinflationpercentage*obj.getBaseLineYearSpend())));



               a.setCotClientShare(Math.round((1-itspendonpersonalpercentage)*cot.getYearBaseCostCalculations().get(0).getClient_share_value()));
                a.setYearlyRunRate((long)Math.round(a.getCotClientShare()+a.getItSpendWithInflation()));
                itspent_with_inflation_total=(long) a.getItSpendWithInflation();
                
            }
            if(i==2) {
                a.setItSpendWithInflation((long) Math.round(itspent_with_inflation_total+(annualinflationpercentage*itspent_with_inflation_total)));
                a.setCotClientShare(Math.round((1-itspendonpersonalpercentage)*cot.getYearBaseCostCalculations().get(1).getClient_share_value()));
                a.setYearlyRunRate((long)Math.round (a.getCotClientShare()+a.getItSpendWithInflation()));
                itspent_with_inflation_total=(long) (itspent_with_inflation_total+a.getItSpendWithInflation());
                secondyear=(long) a.getItSpendWithInflation();
                
            }
            if(i==3) {
                
                a.setItSpendWithInflation((long) Math.round(secondyear+(annualinflationpercentage*secondyear)));
                a.setCotClientShare(Math.round((1-itspendonpersonalpercentage)*cot.getYearBaseCostCalculations().get(2).getClient_share_value()));
                a.setYearlyRunRate((long)Math.round (a.getCotClientShare()+a.getItSpendWithInflation()));
                itspent_with_inflation_total=(long) (itspent_with_inflation_total+a.getItSpendWithInflation());
                
            }
            yearly_run_rate_total=(long) (a.getYearlyRunRate()+yearly_run_rate_total);
            cost_of_transformation_clint_total=(long) (a.getCotClientShare()+cost_of_transformation_clint_total);
            yrBasedCalc.add(a);
     }
        obj.setTotal_cotClientShare(cost_of_transformation_clint_total);
	    obj.setTotal_yearlyRunRate(yearly_run_rate_total);
	    obj.setTotal_itSpendWithInflation(itspent_with_inflation_total);
	    obj.setRunCalc(yrBasedCalc);
        return obj;
    
    }
	
	
//Hardware Asset Classification
	
	public AssetClassificationHardwareDto hardwareCalculation(AssetClassificationHardwareDto h, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
		
		AssetClassificationHardwareDto obj1= new AssetClassificationHardwareDto();
		double hardware_percentage=(double)isc.getHardware()/100;
		obj1.setPerc_split_hardware(isc.getHardware());
		obj1.setBaseLine_hardware((long) Math.round(hardware_percentage*run.getBaseLineYearSpend()));
		
		
		long initial_spend_increase =obj1.getBaseLine_hardware();
		
		
		AssetClassificationHardwareYear asc= new AssetClassificationHardwareYear();
		
		
		double total_eliminate_reducpercentage=0;
		double total_eliminate_retirepercentage=0;
		double total_consolidate_percentage=0;
		double total_rationalize_percentage=0;
		float saving_subtotal_perc=0;
		double saving_subtotal=0;

		
		ArrayList<AssetClassificationHardwareYear> hardcalc=new ArrayList<AssetClassificationHardwareYear>();
		

		 for(int i=1;i<=3;i++) {

			
	            AssetClassificationHardwareYear  obj2 = new AssetClassificationHardwareYear();
	            obj2.setYear(i);
	            obj2.setConsolidate_realignRedistribute(h.getHardwareCalculations().get(i-1).getConsolidate_realignRedistribute());
	            obj2.setEliminate_reducdancyElimination(h.getHardwareCalculations().get(i-1).getEliminate_reducdancyElimination());
	            obj2.setEliminate_retireDecommision(h.getHardwareCalculations().get(i-1).getEliminate_retireDecommision());
	           obj2.setRationalize_automateMl(h.getHardwareCalculations().get(i-1).getRationalize_automateMl());
			
			obj2.setSpendIncreaseWithInflation_h((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
			
			initial_spend_increase = obj2.getSpendIncreaseWithInflation_h();
				System.out.println("spend increase with infl "+ obj2.getSpendIncreaseWithInflation_h());
			
			
			obj2.setSavingSubtotal_perc_h(obj2.getEliminate_reducdancyElimination()+obj2.getEliminate_retireDecommision()+obj2.getConsolidate_realignRedistribute()+obj2.getRationalize_automateMl());
			double saving_subtotalpercentage=(float)obj2.getSavingSubtotal_perc_h()/100;
			obj2.setSavingSubtotal_value_h(Math.round(saving_subtotalpercentage*initial_spend_increase));
			
			total_eliminate_reducpercentage=obj2.getEliminate_reducdancyElimination()+total_eliminate_reducpercentage;
			total_eliminate_retirepercentage=obj2.getEliminate_retireDecommision()+total_eliminate_retirepercentage;
			total_consolidate_percentage=obj2.getConsolidate_realignRedistribute()+total_consolidate_percentage;
			total_rationalize_percentage=obj2.getRationalize_automateMl()+total_rationalize_percentage;
			saving_subtotal_perc= (obj2.getSavingSubtotal_perc_h()+saving_subtotal_perc);
			saving_subtotal=obj2.getSavingSubtotal_value_h()+saving_subtotal;
			hardcalc.add(obj2);
			
		}
		 obj1.setTotal_eliminateReduc((float) total_eliminate_reducpercentage);
		 obj1.setTotal_eliminateRetire((float) total_eliminate_retirepercentage);
		 obj1.setTotal_rationalize((float) total_rationalize_percentage);
		 obj1.setTotal_consolidate((float) total_consolidate_percentage);
		 obj1.setTotal_value_h(saving_subtotal);
		 obj1.setTotal_perc_h(saving_subtotal_perc);
		 
		 obj1.setHardwareCalculations(hardcalc);		
		return obj1;
	}
	
//Software Asset Classification
	
 public AssetClassificationSoftwareDto softwareCalculation(AssetClassificationSoftwareDto s, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
	AssetClassificationSoftwareDto obj3= new AssetClassificationSoftwareDto();
	double software_percentage=(double)isc.getSoftware()/100;
	obj3.setPerc_split_software(isc.getSoftware());
	obj3.setBaseLine_software((long) Math.round(software_percentage*run.getBaseLineYearSpend()));
	
	
	long initial_spend_increase =obj3.getBaseLine_software();
	
	
	AssetClassificationSoftwareYear asc= new AssetClassificationSoftwareYear();
	
	
	double total_rationalize=0;
	double total_std_platform=0;
	double total_transform=0;
	double total_eliminate=0;
	float saving_subtotal_perc_s=0;
	double saving_subtotal_s=0;

	
	ArrayList<AssetClassificationSoftwareYear> softcalc=new ArrayList<AssetClassificationSoftwareYear>();
	

	 for(int i=1;i<=3;i++) {

		
            AssetClassificationSoftwareYear  obj4 = new AssetClassificationSoftwareYear();
            obj4.setYear(i);
            obj4.setRationalize_refactor(s.getSoftwareCalculations().get(i-1).getRationalize_refactor());
            obj4.setStd_platform(s.getSoftwareCalculations().get(i-1).getStd_platform());
            obj4.setTransform_distributed_agile(s.getSoftwareCalculations().get(i-1).getTransform_distributed_agile());
            obj4.setEliminate_redundancy(s.getSoftwareCalculations().get(i-1).getEliminate_redundancy());
		
		obj4.setSpendIncreaseWithInflation_s((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj4.getSpendIncreaseWithInflation_s();
			System.out.println("spend increase with infl "+ obj4.getSpendIncreaseWithInflation_s());
		
		
		obj4.setSavingSubtotal_perc_s(obj4.getRationalize_refactor()+obj4.getStd_platform()+obj4.getTransform_distributed_agile()+obj4.getEliminate_redundancy());
		double saving_subtotalpercentage=(float)obj4.getSavingSubtotal_perc_s()/100;
		obj4.setSavingSubtotal_value_s(Math.round(saving_subtotalpercentage*initial_spend_increase));
		
		total_rationalize=obj4.getRationalize_refactor()+total_rationalize;
		total_std_platform=obj4.getStd_platform()+total_std_platform;
		total_transform=obj4.getTransform_distributed_agile()+total_transform;
		total_eliminate=obj4.getEliminate_redundancy()+total_eliminate;
		saving_subtotal_perc_s= (obj4.getSavingSubtotal_perc_s()+saving_subtotal_perc_s);
		saving_subtotal_s=obj4.getSavingSubtotal_value_s()+saving_subtotal_s;
		softcalc.add(obj4);
		
	}
	 obj3.setTotal_rationalize((float) total_rationalize);
	 obj3.setTotal_std_platform((float) total_std_platform);
	 obj3.setTotal_transform((float) total_transform);
	 obj3.setTotal_eliminate((float) total_eliminate);
	 obj3.setTotal_value_s(saving_subtotal_s);
	 obj3.setTotal_perc_s(saving_subtotal_perc_s);
	 
	 obj3.setSoftwareCalculations(softcalc);		
	return obj3;
}
//Managed Services Asset Classification
 public AssetClassificationManagedServicesDto managedCalculation(AssetClassificationManagedServicesDto m, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
	AssetClassificationManagedServicesDto obj1= new AssetClassificationManagedServicesDto();
	double managed_percentage=(double)isc.getManagedServices()/100;
	obj1.setPerc_split_managed_services(isc.getManagedServices());
	obj1.setBaseLine_managed_services((long) Math.round(managed_percentage*run.getBaseLineYearSpend()));
	
	
	long initial_spend_increase =obj1.getBaseLine_managed_services();
	
	
	AssetClassificationManagedServicesYear asc= new AssetClassificationManagedServicesYear();
	
	
	double total_industrialize_shiftleftpercentage=0;
	double total_industrialize_automatepercentage=0;
	double total_industrialize_realtime_percentage=0;
	double total_synergize_selfservice_percentage=0;
	float saving_subtotal_perc=0;
	double saving_subtotal=0;

	
	ArrayList<AssetClassificationManagedServicesYear> mangcalc=new ArrayList<AssetClassificationManagedServicesYear>();
	

	 for(int i=1;i<=3;i++) {

		
         AssetClassificationManagedServicesYear  obj2 = new AssetClassificationManagedServicesYear();
         obj2.setYear(i);
         obj2.setIndustrialize_shiftleft(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_shiftleft());
         obj2.setIndustrialize_automate(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_automate());
         obj2.setIndustrialize_realtime(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_realtime());
        obj2.setSynergize_selfservice(m.getManaged_servicesCalculations().get(i-1).getSynergize_selfservice());
		
		obj2.setSpendIncreaseWithInflation_m((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj2.getSpendIncreaseWithInflation_m();
			System.out.println("spend increase with infl "+ obj2.getSpendIncreaseWithInflation_m());
		
		
		obj2.setSavingSubtotal_perc_m(obj2.getIndustrialize_shiftleft()+obj2.getIndustrialize_automate()+obj2.getIndustrialize_realtime()+obj2.getSynergize_selfservice());
		double saving_subtotalpercentage=(float)obj2.getSavingSubtotal_perc_m()/100;
		obj2.setSavingSubtotal_value_m(Math.round(saving_subtotalpercentage*initial_spend_increase));
		
		total_industrialize_shiftleftpercentage=obj2.getIndustrialize_shiftleft()+total_industrialize_shiftleftpercentage;
		total_industrialize_automatepercentage=obj2.getIndustrialize_automate()+total_industrialize_automatepercentage;
		total_industrialize_realtime_percentage=obj2.getIndustrialize_realtime()+total_industrialize_realtime_percentage;
		total_synergize_selfservice_percentage=obj2.getSynergize_selfservice()+total_synergize_selfservice_percentage;
		saving_subtotal_perc= (obj2.getSavingSubtotal_perc_m()+saving_subtotal_perc);
		saving_subtotal=obj2.getSavingSubtotal_value_m()+saving_subtotal;
		mangcalc.add(obj2);
		
	}
	 obj1.setTotal_ishiftleft((float) total_industrialize_shiftleftpercentage);
	 obj1.setTotal_std_iautomate((float) total_industrialize_automatepercentage);
	 obj1.setTotal_irealtime((float) total_industrialize_realtime_percentage);
	 obj1.setTotal_synergize((float) total_synergize_selfservice_percentage);
	 obj1.setTotal_value_m((float) saving_subtotal);
	 obj1.setTotal_perc_m(saving_subtotal_perc);
	 
	 obj1.setManaged_servicesCalculations(mangcalc);		
	return obj1;
}

//Hosted Cloud Based Services Asset Classification
 
 public AssetClassificationHostedCbsDto hostedCalculation(AssetClassificationHostedCbsDto host, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
	AssetClassificationHostedCbsDto obj1= new AssetClassificationHostedCbsDto();
	double hosted_percentage=(double)isc.getHosted_cbs()/100;
	obj1.setPerc_split_hosted_cbs(isc.getHosted_cbs());
	obj1.setBaseLine_hosted_cbs((long) Math.round(hosted_percentage*run.getBaseLineYearSpend()));
	
	
	long initial_spend_increase =obj1.getBaseLine_hosted_cbs();
	
	
	AssetClassificationHostedCbsYear asc= new AssetClassificationHostedCbsYear();
	
	
	double total_transform_cloud_percentage=0;
	float saving_subtotal_perc=0;
	double saving_subtotal=0;

	
	ArrayList<AssetClassificationHostedCbsYear> hostcalc=new ArrayList<AssetClassificationHostedCbsYear>();
	

	 for(int i=1;i<=3;i++) {

		
      AssetClassificationHostedCbsYear  obj2 = new AssetClassificationHostedCbsYear();
      obj2.setYear(i);
      obj2.setTransform_cloud(host.getHosted_cbsCalculations().get(i-1).getTransform_cloud());
		
		obj2.setSpendIncreaseWithInflation_host((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj2.getSpendIncreaseWithInflation_host();
			System.out.println("spend increase with infl "+ obj2.getSpendIncreaseWithInflation_host());
		
		
		obj2.setSavingSubtotal_perc_host(obj2.getTransform_cloud());
		double saving_subtotalpercentage=obj2.getSavingSubtotal_perc_host()/100;
		obj2.setSavingSubtotal_value_host ((double)Math.round(saving_subtotalpercentage*initial_spend_increase));
		
		total_transform_cloud_percentage=obj2.getTransform_cloud()+total_transform_cloud_percentage;
		saving_subtotal_perc= (obj2.getSavingSubtotal_perc_host()+saving_subtotal_perc);
		saving_subtotal=obj2.getSavingSubtotal_value_host()+saving_subtotal;
		hostcalc.add(obj2);
		
	}
	 obj1.setTotal_transform_cloud((float) total_transform_cloud_percentage);
	 obj1.setTotal_value_host((float) saving_subtotal);
	 obj1.setTotal_perc_host(saving_subtotal_perc);
	 
	 obj1.setHosted_cbsCalculations(hostcalc);		
	return obj1;
}
 
//It Spend on Assets without personnel
 public AssetClassificationDto itspendcalculation(AssetClassificationHardwareDto h,AssetClassificationSoftwareDto s,AssetClassificationManagedServicesDto m, AssetClassificationHostedCbsDto host) {
		
		AssetClassificationDto obj1= new AssetClassificationDto();
		obj1.setItspendonassets_baseline(h.getBaseLine_hardware()+s.getBaseLine_software()+m.getBaseLine_managed_services()+host.getBaseLine_hosted_cbs());
		
		ArrayList<ItSpendOnAssetsTotalYear> itspendcalc=new ArrayList<ItSpendOnAssetsTotalYear>();
		
		
		for(int i=1;i<=3;i++) {
			ItSpendOnAssetsTotalYear  obj2 = new ItSpendOnAssetsTotalYear();
		      obj2.setYear(i);
		      obj2.setItspendonassets_year(h.getHardwareCalculations().get(i-1).getSpendIncreaseWithInflation_h()+s.getSoftwareCalculations().get(i-1).getSpendIncreaseWithInflation_s()+m.getManaged_servicesCalculations().get(i-1).getSpendIncreaseWithInflation_m()+host.getHosted_cbsCalculations().get(i-1).getSpendIncreaseWithInflation_host());
		      itspendcalc.add(obj2);
		
		}
		obj1.setItspendcalc(itspendcalc);	
 
		return obj1;
 }
 //Savings through Optimization Levers
 public SavingsOptimizationDto savingsoptimizationcalculation(AssetClassificationHardwareDto h,AssetClassificationSoftwareDto s,AssetClassificationManagedServicesDto m, AssetClassificationHostedCbsDto host,ItPersonnelDto itp,CostofTransformationDto cot,ItRunSpendDto run) {
		
	 SavingsOptimizationDto obj1= new SavingsOptimizationDto();
		
		ArrayList<SavingsOptimizationYear> savingcalc=new ArrayList<SavingsOptimizationYear>();
		long initial_cot_value=0;
		long total_saving_levers=0;
		long total_cot_partner_share=0;
		long sum_total_savings=0;
		long cot_partner_share=0;
		long total_run_businessit=0;
		
		for(int i=1;i<=3;i++) {
			SavingsOptimizationYear  obj2 = new SavingsOptimizationYear();
		      obj2.setYear(i);
		      obj2.setSaving_levers((long) (h.getHardwareCalculations().get(i-1).getSavingSubtotal_value_h()+s.getSoftwareCalculations().get(i-1).getSavingSubtotal_value_s()+m.getManaged_servicesCalculations().get(i-1).getSavingSubtotal_value_m()+host.getHosted_cbsCalculations().get(i-1).getSavingSubtotal_value_host()));
		     
		      double itspend_onpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
		      obj2.setCot_partner_share((long) ((1-itspend_onpersonalpercentage)*cot.getYearBaseCostCalculations().get(i-1).getPartner_share_value()));
		      obj2.setTotal_savings_model(obj2.getSaving_levers()+obj2.getCot_partner_share());
		      obj2.setRun_businessit((long) (run.getRunCalc().get(i-1).getYearlyRunRate())-obj2.getTotal_savings_model());
	
		      cot_partner_share=obj2.getCot_partner_share();
		      obj2.setTotal_cot_partner(cot_partner_share+initial_cot_value); 
		      initial_cot_value=obj2.getTotal_cot_partner();
		      
		      total_saving_levers =obj2.getTotal_savings_model();
		      total_cot_partner_share= obj2.getTotal_cot_partner();
		      
		      savingcalc.add(obj2);
		
		}
		obj1.setTotal_saving_levers((long) (h.getTotal_value_h()+s.getTotal_value_s()+m.getTotal_value_m()+host.getTotal_value_host()));
		
		sum_total_savings =(total_saving_levers+total_cot_partner_share);
		total_run_businessit=(long) (run.getRunCalc().get(0).getYearlyRunRate()-initial_cot_value);
		obj1.setMain_total_run_businessit((long) (run.getRunCalc().get(0).getYearlyRunRate()-total_run_businessit));
		
		obj1.setSum_total_savings(sum_total_savings);
		obj1.setTotal_run_businessit(total_run_businessit);
		
		obj1.setSavingsoptimizationcalculation(savingcalc);	
		return obj1;
}
 
//It Spend on Run Personnel
 public ItSpendOnRunPersonnelDto runpersonnelcalculation(ItPersonnelDto itp, InputTablesDto inp, CostofTransformationDto cot) {
	    
	 ItSpendOnRunPersonnelDto obj=new ItSpendOnRunPersonnelDto();
     double itspendonpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
     double annualinflationpercentage=inp.getAnnual_inflation_perc()/100;
     
     obj.setItspend_baseline(itp.getRun_fte_personal());
    
    
     ArrayList<ItSpendOnRunPersonnelYear> yrCalc=new ArrayList<ItSpendOnRunPersonnelYear>();
   
     long secondyear=0;
     long itspent_with_inflation_total=0;
     long cost_of_transformation_clint_total=0;
     long yearly_run_rate_total=0;
     
         
     for(int i=1;i<=3;i++) {
    	 ItSpendOnRunPersonnelYear  a = new ItSpendOnRunPersonnelYear();
         a.setYear(i);
         if(i==1) {
             
             a.setItSpendWithInflation( Math.round(obj.getItspend_baseline()+(annualinflationpercentage*obj.getItspend_baseline())));
            a.setCotClientShare(Math.round(itspendonpersonalpercentage*cot.getYearBaseCostCalculations().get(0).getClient_share_value()));
             a.setYearlyRunRate(Math.round(a.getCotClientShare()+a.getItSpendWithInflation()));
             itspent_with_inflation_total=(long) a.getItSpendWithInflation();
             
         }
         if(i==2) {
             a.setItSpendWithInflation((long) Math.round(itspent_with_inflation_total+(annualinflationpercentage*itspent_with_inflation_total)));
             a.setCotClientShare(Math.round(itspendonpersonalpercentage*cot.getYearBaseCostCalculations().get(1).getClient_share_value()));
             a.setYearlyRunRate((long)Math.round (a.getCotClientShare()+a.getItSpendWithInflation()));
             itspent_with_inflation_total=(long) (itspent_with_inflation_total+a.getItSpendWithInflation());
             secondyear=(long) a.getItSpendWithInflation();
             
         }
         if(i==3) {
             
             a.setItSpendWithInflation((long) Math.round(secondyear+(annualinflationpercentage*secondyear)));
             a.setCotClientShare(Math.round(itspendonpersonalpercentage*cot.getYearBaseCostCalculations().get(2).getClient_share_value()));
             a.setYearlyRunRate((long)Math.round (a.getCotClientShare()+a.getItSpendWithInflation()));
             itspent_with_inflation_total=(long) (itspent_with_inflation_total+a.getItSpendWithInflation());
             
         }
         yearly_run_rate_total=(long) (a.getYearlyRunRate()+yearly_run_rate_total);
         cost_of_transformation_clint_total=(long) (a.getCotClientShare()+cost_of_transformation_clint_total);
         yrCalc.add(a);
  }
     obj.setTotal_cotClientShare(cost_of_transformation_clint_total);
	    obj.setTotal_yearlyRunRate(yearly_run_rate_total);
	    obj.setTotal_itSpendWithInflation(itspent_with_inflation_total);
	    obj.setRunpersonnelcalculation(yrCalc);
     return obj;
 
 }
}