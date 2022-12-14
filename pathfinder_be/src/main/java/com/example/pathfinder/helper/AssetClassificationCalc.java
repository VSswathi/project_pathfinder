package com.example.pathfinder.helper;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.AssetClassificationDto;
import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHardwareYear;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsYear;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesYear;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareYear;
import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItRunSpendDto;
import com.example.pathfinder.dto.ItRunYearlyDto;
import com.example.pathfinder.dto.ItSpendCategoriesDto;
import com.example.pathfinder.dto.ItSpendOnAssetsTotalYear;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelYear;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.dto.SavingsOptimizationYear;
import com.example.pathfinder.repo.CostofTransformationRepo;

@Component
public class AssetClassificationCalc {

	@Autowired
	CostofTransformationRepo cotRepo;

// 6-pathfinder_itrun_spend
	
	public ItRunSpendDto yearBasedCalculation(ItPersonnelDto itp, InputTablesDto inp, CostofTransformationDto cot) {
	    
        ItRunSpendDto obj=new ItRunSpendDto();
        double itspendonpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
        double annualinflationpercentage=inp.getAnnual_inflation_perc()/100;
        
       obj.setBaseLineYearSpend((long) (inp.getRun_business_value()-(itspendonpersonalpercentage*inp.getRun_business_value())));    
       
        ArrayList<ItRunYearlyDto> yrBasedCalc=new ArrayList<ItRunYearlyDto>();
      
        long itspent_with_inflation_total=0;
        long cost_of_transformation_clint_total=0;
        long yearly_run_rate_total=0;
        
        int i=cot.getYearBaseCostCalculations().size();
		
		long initial_baseline = obj.getBaseLineYearSpend();
		
		for(int k=0;k<i;k++) {
			ItRunYearlyDto obj1= new ItRunYearlyDto();
			obj1.setYear(k+1);
			obj1.setItSpendWithInflation((long) Math.abs(initial_baseline+(annualinflationpercentage*initial_baseline)));
			initial_baseline= (long) obj1.getItSpendWithInflation();
			itspent_with_inflation_total=(long) (itspent_with_inflation_total+obj1.getItSpendWithInflation());
			
			obj1.setCotClientShare((long) Math.abs((1-itspendonpersonalpercentage)*cot.getYearBaseCostCalculations().get(k).getClient_share_value()));
			
			obj1.setYearlyRunRate(Math.abs(obj1.getItSpendWithInflation()+obj1.getCotClientShare()));
			
			yearly_run_rate_total=(long) (obj1.getYearlyRunRate()+yearly_run_rate_total);
            cost_of_transformation_clint_total=(long) (obj1.getCotClientShare()+cost_of_transformation_clint_total);
            yrBasedCalc.add(obj1);
		}

        obj.setTotal_cotClientShare(cost_of_transformation_clint_total);
	    obj.setTotal_yearlyRunRate(yearly_run_rate_total);
	    obj.setTotal_itSpendWithInflation(itspent_with_inflation_total);
	    obj.setRunCalc(yrBasedCalc);
        return obj;
    
    }
	
	
// 7-pathfinder_asset_classification_hardware
	
	public AssetClassificationHardwareDto hardwareCalculation(AssetClassificationHardwareDto h, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
		
		AssetClassificationHardwareDto obj1= new AssetClassificationHardwareDto();
		double hardware_percentage=(double)isc.getHardware()/100;
		obj1.setPerc_split_hardware(isc.getHardware());
		obj1.setBaseLine_hardware((long) Math.round(hardware_percentage*run.getBaseLineYearSpend()));
		
		
		long initial_spend_increase =obj1.getBaseLine_hardware();
	
		
		
		double total_eliminate_reducpercentage=0;
		double total_eliminate_retirepercentage=0;
		double total_consolidate_percentage=0;
		double total_rationalize_percentage=0;
		float saving_subtotal_perc=0;
		double saving_subtotal=0;

		int i=1;
		ArrayList<AssetClassificationHardwareYear> hardcalc=new ArrayList<AssetClassificationHardwareYear>();
		
		        for(AssetClassificationHardwareYear obj2:    h.getHardwareCalculations()){
			
	            obj2.setYear(i);
	            obj2.setConsolidate_realignRedistribute(h.getHardwareCalculations().get(i-1).getConsolidate_realignRedistribute());
	            obj2.setEliminate_reducdancyElimination(h.getHardwareCalculations().get(i-1).getEliminate_reducdancyElimination());
	            obj2.setEliminate_retireDecommision(h.getHardwareCalculations().get(i-1).getEliminate_retireDecommision());
	           obj2.setRationalize_automateMl(h.getHardwareCalculations().get(i-1).getRationalize_automateMl());
			
			obj2.setSpendIncreaseWithInflation_h((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
			
			initial_spend_increase = obj2.getSpendIncreaseWithInflation_h();
			
			
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
			i++;
			
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
	
	
	
// 8-pathfinder_asset_classification_software
	
	public AssetClassificationSoftwareDto softwareCalculation(AssetClassificationSoftwareDto s, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
		AssetClassificationSoftwareDto obj3= new AssetClassificationSoftwareDto();
		double software_percentage=(double)isc.getSoftware()/100;
		obj3.setPerc_split_software(isc.getSoftware());
		obj3.setBaseLine_software((long) Math.round(software_percentage*run.getBaseLineYearSpend()));
		
		
		long initial_spend_increase =obj3.getBaseLine_software();
		
	
	
	double total_rationalize=0;
	double total_std_platform=0;
	double total_transform=0;
	double total_eliminate=0;
	float saving_subtotal_perc_s=0;
	double saving_subtotal_s=0;

	int i=1;
	ArrayList<AssetClassificationSoftwareYear> softcalc=new ArrayList<AssetClassificationSoftwareYear>();
	
	 for(AssetClassificationSoftwareYear obj4:    s.getSoftwareCalculations()){
		
            obj4.setYear(i);
            obj4.setRationalize_refactor(s.getSoftwareCalculations().get(i-1).getRationalize_refactor());
            obj4.setStd_platform(s.getSoftwareCalculations().get(i-1).getStd_platform());
            obj4.setTransform_distributed_agile(s.getSoftwareCalculations().get(i-1).getTransform_distributed_agile());
            obj4.setEliminate_redundancy(s.getSoftwareCalculations().get(i-1).getEliminate_redundancy());
		
		obj4.setSpendIncreaseWithInflation_s((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj4.getSpendIncreaseWithInflation_s();
		
		
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
		i++;
		
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
	
	
// 9-pathfinder_asset_classification_managed
	
	public AssetClassificationManagedServicesDto managedCalculation(AssetClassificationManagedServicesDto m, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
	AssetClassificationManagedServicesDto obj1= new AssetClassificationManagedServicesDto();
	double managed_percentage=(double)isc.getManagedServices()/100;
	obj1.setPerc_split_managed_services(isc.getManagedServices());
	obj1.setBaseLine_managed_services((long) Math.round(managed_percentage*run.getBaseLineYearSpend()));
	
	
	long initial_spend_increase =obj1.getBaseLine_managed_services();
	
	
	double total_industrialize_shiftleftpercentage=0;
	double total_industrialize_automatepercentage=0;
	double total_industrialize_realtime_percentage=0;
	double total_synergize_selfservice_percentage=0;
	float saving_subtotal_perc=0;
	double saving_subtotal=0;

	int i=1;
	ArrayList<AssetClassificationManagedServicesYear> mangcalc=new ArrayList<AssetClassificationManagedServicesYear>();
	

	 for(AssetClassificationManagedServicesYear obj2:  m.getManaged_servicesCalculations()){

         obj2.setYear(i);
         obj2.setIndustrialize_shiftleft(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_shiftleft());
         obj2.setIndustrialize_automate(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_automate());
         obj2.setIndustrialize_realtime(m.getManaged_servicesCalculations().get(i-1).getIndustrialize_realtime());
        obj2.setSynergize_selfservice(m.getManaged_servicesCalculations().get(i-1).getSynergize_selfservice());
		
		obj2.setSpendIncreaseWithInflation_m((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj2.getSpendIncreaseWithInflation_m();
		
		
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
		i++;
		
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

	
	
//	10-pathfinder_asset_classification_hosted
 
	public AssetClassificationHostedCbsDto hostedCalculation(AssetClassificationHostedCbsDto host, ItRunSpendDto run, InputTablesDto inp, ItSpendCategoriesDto isc) {
	
	AssetClassificationHostedCbsDto obj1= new AssetClassificationHostedCbsDto();
	double hosted_percentage=(double)isc.getHosted_cbs()/100;
	obj1.setPerc_split_hosted_cbs(isc.getHosted_cbs());
	obj1.setBaseLine_hosted_cbs((long) Math.round(hosted_percentage*run.getBaseLineYearSpend()));
	
	
	long initial_spend_increase =obj1.getBaseLine_hosted_cbs();
	
	
	
	double total_transform_cloud_percentage=0;
	float saving_subtotal_perc=0;
	double saving_subtotal=0;

	int i=1;
	ArrayList<AssetClassificationHostedCbsYear> hostcalc=new ArrayList<AssetClassificationHostedCbsYear>();

	 for(AssetClassificationHostedCbsYear obj2:    host.getHosted_cbsCalculations()){

      obj2.setYear(i);
      obj2.setTransform_cloud(host.getHosted_cbsCalculations().get(i-1).getTransform_cloud());
		
		obj2.setSpendIncreaseWithInflation_host((long) Math.round(initial_spend_increase+(initial_spend_increase*(double)inp.getAnnual_inflation_perc()/100)));
		
		initial_spend_increase = obj2.getSpendIncreaseWithInflation_host();

		
		
		obj2.setSavingSubtotal_perc_host(obj2.getTransform_cloud());
		double saving_subtotalpercentage=obj2.getSavingSubtotal_perc_host()/100;
		obj2.setSavingSubtotal_value_host ((double)Math.round(saving_subtotalpercentage*initial_spend_increase));
		
		total_transform_cloud_percentage=obj2.getTransform_cloud()+total_transform_cloud_percentage;
		saving_subtotal_perc= (obj2.getSavingSubtotal_perc_host()+saving_subtotal_perc);
		saving_subtotal=obj2.getSavingSubtotal_value_host()+saving_subtotal;
		hostcalc.add(obj2);
		i++;
		
	}
	 obj1.setTotal_transform_cloud((float) total_transform_cloud_percentage);
	 obj1.setTotal_value_host((float) saving_subtotal);
	 obj1.setTotal_perc_host(saving_subtotal_perc);
	 
	 obj1.setHosted_cbsCalculations(hostcalc);		
	return obj1;
}
 
	
// 11-pathfinder_asset_total
	
	public AssetClassificationDto itspendcalculation(AssetClassificationHardwareDto h,AssetClassificationSoftwareDto s,AssetClassificationManagedServicesDto m, AssetClassificationHostedCbsDto host) {
		
		AssetClassificationDto obj1= new AssetClassificationDto();
		obj1.setItspendonassets_baseline(h.getBaseLine_hardware()+s.getBaseLine_software()+m.getBaseLine_managed_services()+host.getBaseLine_hosted_cbs());

		int i=h.getHardwareCalculations().size();

		ArrayList<ItSpendOnAssetsTotalYear> cal=new ArrayList<ItSpendOnAssetsTotalYear>();
		
		for(int k=0;k<i;k++) {
			ItSpendOnAssetsTotalYear newobj= new ItSpendOnAssetsTotalYear();

			long a=h.getHardwareCalculations().get(k).getSpendIncreaseWithInflation_h();
			long b=s.getSoftwareCalculations().get(k).getSpendIncreaseWithInflation_s();
			long c=m.getManaged_servicesCalculations().get(k).getSpendIncreaseWithInflation_m();
			long d=host.getHosted_cbsCalculations().get(k).getSpendIncreaseWithInflation_host();
			long total=a+b+c+d;
			newobj.setYear(k+1);
			newobj.setItspendonassets_year(total);
			cal.add(newobj);
			
		}
		obj1.setItspendcalc(cal);
		
	
 
		return obj1;
 }
	
	
// 12-pathfinder_saving_optimization
 
	public SavingsOptimizationDto savingsoptimizationcalculation(AssetClassificationHardwareDto h,AssetClassificationSoftwareDto s,AssetClassificationManagedServicesDto m, AssetClassificationHostedCbsDto host,ItPersonnelDto itp,CostofTransformationDto cot,ItRunSpendDto run) {
		
	 SavingsOptimizationDto obj1= new SavingsOptimizationDto();
		
		ArrayList<SavingsOptimizationYear> savingcalc=new ArrayList<SavingsOptimizationYear>();
		long initial_cot_value=0;
		long total_saving_levers=0;
		long total_cot_partner_share=0;
		long sum_total_savings=0;
		long cot_partner_share=0;
		long total_run_businessit=0;
		long cot_partner_value=0;

		
		int i=h.getHardwareCalculations().size();
		for(int k=0;k<i;k++) {

			SavingsOptimizationYear  obj2 = new SavingsOptimizationYear();
		      obj2.setYear(k+1);
		      obj2.setSaving_levers((long) (h.getHardwareCalculations().get(k).getSavingSubtotal_value_h()+s.getSoftwareCalculations().get(k).getSavingSubtotal_value_s()+m.getManaged_servicesCalculations().get(k).getSavingSubtotal_value_m()+host.getHosted_cbsCalculations().get(k).getSavingSubtotal_value_host()));
		     
		      double itspend_onpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
		      obj2.setCot_partner_share((long) ((1-itspend_onpersonalpercentage)*cot.getYearBaseCostCalculations().get(k).getPartner_share_value()));
		      obj2.setTotal_savings_model(obj2.getSaving_levers()+obj2.getCot_partner_share());
		      obj2.setRun_businessit((long) (run.getRunCalc().get(k).getYearlyRunRate())-obj2.getTotal_savings_model());
	
		      cot_partner_share=obj2.getCot_partner_share();
		      cot_partner_value=(cot_partner_share+initial_cot_value); 
		      initial_cot_value=cot_partner_value;
		      
		      total_saving_levers =obj2.getTotal_savings_model();		      
		      savingcalc.add(obj2);
		
		}
		obj1.setTotal_saving_levers((long) (h.getTotal_value_h()+s.getTotal_value_s()+m.getTotal_value_m()+host.getTotal_value_host()));
		obj1.setTotal_cot_partner(cot_partner_value);
		
		sum_total_savings =(total_saving_levers+total_cot_partner_share);
		total_run_businessit=(long) (run.getRunCalc().get(0).getYearlyRunRate()-sum_total_savings);
		obj1.setMain_total_run_businessit((long) (run.getRunCalc().get(0).getYearlyRunRate()-total_run_businessit));
		
		obj1.setSum_total_savings(sum_total_savings);
		obj1.setTotal_run_businessit(total_run_businessit);
		
		obj1.setSavingsoptimizationcalculation(savingcalc);	
		return obj1;
}
 
	
	
// 13-pathfinder_itspend_run_personnel
 
	public ItSpendOnRunPersonnelDto runpersonnelcalculation(ItPersonnelDto itp, InputTablesDto inp, CostofTransformationDto cot) {
	    
	 ItSpendOnRunPersonnelDto obj=new ItSpendOnRunPersonnelDto();
     double itspendonpersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
     double annualinflationpercentage=inp.getAnnual_inflation_perc()/100;
     
     obj.setItspend_baseline(itp.getRun_fte_personal());
    
    
     ArrayList<ItSpendOnRunPersonnelYear> yrCalc=new ArrayList<ItSpendOnRunPersonnelYear>();
   
     long itspent_with_inflation_total=0;
     long cost_of_transformation_clint_total=0;
     long yearly_run_rate_total=0;
     long initial_baseline=obj.getItspend_baseline();
     
     int i=cot.getYearBaseCostCalculations().size();
		for(int k=0;k<i;k++) {
         
    	 ItSpendOnRunPersonnelYear  obj1 = new ItSpendOnRunPersonnelYear();
         obj1.setYear(k+1);
      
         obj1.setItSpendWithInflation((long) Math.abs(initial_baseline+(annualinflationpercentage*initial_baseline)));
			initial_baseline= (long) obj1.getItSpendWithInflation();
			itspent_with_inflation_total=(long) (itspent_with_inflation_total+obj1.getItSpendWithInflation());
			
			obj1.setCotClientShare((long) (Math.abs(cot.getYearBaseCostCalculations().get(k).getClient_share_value()*itspendonpersonalpercentage)));
			
			obj1.setYearlyRunRate(Math.abs(obj1.getItSpendWithInflation()+obj1.getCotClientShare()));
       
         yearly_run_rate_total=(long) (obj1.getYearlyRunRate()+yearly_run_rate_total);
         cost_of_transformation_clint_total=(long) (obj1.getCotClientShare()+cost_of_transformation_clint_total);
         yrCalc.add(obj1);
  }
     obj.setTotal_cotClientShare(cost_of_transformation_clint_total);
	    obj.setTotal_yearlyRunRate(yearly_run_rate_total);
	    obj.setTotal_itSpendWithInflation(itspent_with_inflation_total);
	    obj.setRunpersonnelcalculation(yrCalc);
     return obj;
 
 }
	
	
}