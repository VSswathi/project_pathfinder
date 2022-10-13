package com.example.pathfinder.helper;

import java.util.ArrayList;




import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.CostofTransformationDto;
import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItPersonalCostDto;
import com.example.pathfinder.dto.ItPersonnelDto;
import com.example.pathfinder.dto.ItSpendCategoriesDto;
import com.example.pathfinder.dto.YearBasedOutsourcingDto;
import com.example.pathfinder.dto.YearBasedTransformationDto;

@Component
public class CalculationHelper {

	
	//1-pathfinder_input_tables
	
	public InputTablesDto calculateValue(InputTablesDto inp) {
		InputTablesDto obj=new InputTablesDto();
		double runBusinesspercentage=inp.getRun_business_perc()/100;
		double growBusinesspercentage=inp.getGrow_business_perc()/100;
		double transformItpercentage=inp.getTransform_it_perc()/100;
		double itSpentpercentage=inp.getIt_spent_perc()/100;
	
		obj.setRun_business_perc(inp.getRun_business_perc());
     	obj.setGrow_business_perc(inp.getGrow_business_perc());
		obj.setTransform_it_perc(inp.getTransform_it_perc());
        obj.setAnnual_revenue_for_client(inp.getAnnual_revenue_for_client());
		obj.setIt_spent_perc(inp.getIt_spent_perc());
        obj.setIt_spent_value((long) (inp.getAnnual_revenue_for_client()*itSpentpercentage));
		obj.setRun_business_value((long) (runBusinesspercentage*obj.getIt_spent_value()));
		obj.setGrow_business_value((long) Math.round(growBusinesspercentage*obj.getIt_spent_value()));
		obj.setTransform_it_value((long) (transformItpercentage*obj.getIt_spent_value()));
		obj.setAnnual_inflation_perc(inp.getAnnual_inflation_perc());
		
		return obj;
	}
	
	
	// 2-pathfinder_it_personnel
	
	public ItPersonnelDto calcValue(ItPersonnelDto itp,InputTablesDto inp) {
		ItPersonnelDto obj7= new ItPersonnelDto();
		
		double runBusinesspercentage=inp.getRun_business_perc()/100;
		double growBusinesspercentage=inp.getGrow_business_perc()/100;
		double transformItpercentage=inp.getTransform_it_perc()/100;
		
		double itSpentonPersonalpercentage=itp.getIt_spend_on_personal_perc()/100;
		double eligibilty=itp.getPerc_eligible_forpersonal()/100;	
		
		obj7.setIt_spend_on_personal_perc(itp.getIt_spend_on_personal_perc());
		obj7.setIt_spend_outsource((long) (itSpentonPersonalpercentage*inp.getIt_spent_value()));
    	obj7.setAvr_ctc_per_fte(itp.getAvr_ctc_per_fte());
		obj7.setAvr_ctc_final(Math.round(obj7.getIt_spend_outsource()/itp.getAvr_ctc_per_fte()));
		obj7.setRun_fte_personal((long) (runBusinesspercentage*obj7.getIt_spend_outsource()));
		obj7.setRun_fte_outsource(Math.round((double)obj7.getRun_fte_personal()/(double)itp.getAvr_ctc_per_fte()));
        obj7.setGrow_fte_personal((long)(growBusinesspercentage*obj7.getIt_spend_outsource()));
		obj7.setGrow_fte_outsource(Math.round((double)obj7.getGrow_fte_personal()/(double)itp.getAvr_ctc_per_fte()));
	    obj7.setTransform_fte_personal((long)(transformItpercentage*obj7.getIt_spend_outsource()));
        obj7.setTransform_fte_outsource(Math.round((double)obj7.getTransform_fte_personal()/(double)itp.getAvr_ctc_per_fte()));
	    obj7.setPerc_eligible_forpersonal(itp.getPerc_eligible_forpersonal());
		obj7.setEligible_outsource(Math.round(eligibilty*obj7.getRun_fte_outsource()));
		
		
		return obj7;
		
	}

	// 3-pathfinder_it_personnel_cost 
	
	public ItPersonalCostDto yearBasedCalculation(ItPersonnelDto itp, ItPersonalCostDto inp) {	   
		        ItPersonalCostDto obj3=new ItPersonalCostDto();
		        
		        obj3.setOffshoreRatio(inp.getOffshoreRatio());
		        obj3.setOnsitRatio(inp.getOnsitRatio());
		        obj3.setPartnerCtcOffshore(inp.getPartnerCtcOffshore());
		        obj3.setPartnerCtcOnsite(inp.getPartnerCtcOnsite());
		        ArrayList<YearBasedOutsourcingDto> years=new ArrayList<YearBasedOutsourcingDto>();


		       long firstYearCumulative=0;
		        int firstYearSavingCumulative=0;
		        
		        for(YearBasedOutsourcingDto obj2:    inp.getYearBseCalculations()){
		            
		            YearBasedOutsourcingDto i = new YearBasedOutsourcingDto();
		            i.setTakeOverPlan(obj2.getTakeOverPlan());
		            i.setPpImprovement(obj2.getPpImprovement());
		            i.setOnsiteRatio(obj2.getOnsiteRatio());
		            i.setOffshoreRatio(obj2.getOffshoreRatio());
		            i.setYearLine(obj2.getYearLine());
		            double takeoverplanpercentage=i.getTakeOverPlan()/100;
		            double ppimprovementpercentage=i.getPpImprovement()/100;
		            double onsiteratiopercentage1=i.getOnsiteRatio()/100;



		           if(obj2.getYearLine()==1) {
		        	   i.setInfteCumulative(Math.round(((double)itp.getEligible_outsource()*(double)takeoverplanpercentage)));
		                i.setFteSavingsCumulative(Math.round((int) (ppimprovementpercentage*i.getInfteCumulative())));
		                firstYearSavingCumulative=i.getFteSavingsCumulative();
		                firstYearCumulative=i.getInfteCumulative();
		                
		                
		            }else{
		                i.setInfteCumulative(Math.round(( firstYearCumulative+((double)itp.getEligible_outsource()*(double)takeoverplanpercentage))));
		                i.setFteSavingsCumulative((int) Math.round((firstYearSavingCumulative+ ((double)ppimprovementpercentage*(double)i.getInfteCumulative()))));
		                firstYearSavingCumulative=i.getFteSavingsCumulative();
		                firstYearCumulative=i.getInfteCumulative();
		            }
		            
		            i.setNetPartnerFte(i.getInfteCumulative()-i.getFteSavingsCumulative());
		            i.setInFteOnsite((long)Math.round((double)i.getNetPartnerFte()*(double) onsiteratiopercentage1));
		            i.setInFteOffshore((long) Math.round((double)i.getNetPartnerFte()-(double)i.getInFteOnsite()));
		            years.add(i);
		            System.out.println("In fte Cumulative= "+i.getInfteCumulative()+", In fte savings cumulative= "+i.getFteSavingsCumulative() + ", net partner Ftes= " + i.getNetPartnerFte() + ", In fte Onsite= "+ i.getInFteOnsite() + ", In fte offshore= "+ i.getInFteOffshore());
		        }
		    
		        obj3.setYearBseCalculations(years);
		             
		        return obj3;
		    }
	
	
	// 4-pathfinder_cost_of_transformation
	
	public CostofTransformationDto YearBasedTransformation( CostofTransformationDto cot,InputTablesDto inp) {
		
		CostofTransformationDto obj4=new CostofTransformationDto();
		
		double cotpercentage=(double)cot.getCot_perc()/100;
		double clientpercentage=cot.getClient_perc()/100;
		double partnerpercentage=cot.getPartner_perc()/100;
		
		
		obj4.setCot_perc(cot.getCot_perc());
		obj4.setCot_value((long) (inp.getRun_business_value()*cotpercentage));
		obj4.setClient_perc(cot.getClient_perc());
		obj4.setClient_value((long) Math.round(clientpercentage*obj4.getCot_value()));
		obj4.setPartner_perc(cot.getPartner_perc());
		obj4.setPartner_value((long) Math.round(partnerpercentage*obj4.getCot_value()));
		
		
		ArrayList<YearBasedTransformationDto> yrs=new ArrayList<YearBasedTransformationDto>();
 
        for(YearBasedTransformationDto obj5:    cot.getYearBaseCostCalculations()){
            
        	YearBasedTransformationDto j = new YearBasedTransformationDto();
        	
        	double cotspreadpercentage=obj5.getCot_spread_perc()/100;
        	double annualInflationpercentage=inp.getAnnual_inflation_perc()/100;
        
        	j.setYear(obj5.getYear());
        	j.setCot_spread_perc(obj5.getCot_spread_perc());
        	
        	j.setClient_share_value((long) Math.round((cotspreadpercentage*obj4.getClient_value())+(annualInflationpercentage*(cotspreadpercentage*obj4.getClient_value()))));
		    j.setPartner_share_value((long) Math.round((cotspreadpercentage*obj4.getPartner_value())+(annualInflationpercentage*(cotspreadpercentage*obj4.getPartner_value()))));
		    j.setTotal_with_inflation((j.getClient_share_value())+(j.getPartner_share_value()));
        	yrs.add(j);
		   
        }
        
        obj4.setYearBaseCostCalculations(yrs);
		
		return obj4;
	}
	
	
	// 5-pathfinder_it_spend_categories
	
	public ItSpendCategoriesDto itspend_categories_calc(ItSpendCategoriesDto isc) {
		
		ItSpendCategoriesDto obj6=new ItSpendCategoriesDto();
		
		obj6.setHardware(isc.getHardware());
		obj6.setSoftware(isc.getSoftware());
		obj6.setHosted_cbs(isc.getHosted_cbs());
		obj6.setManagedServices(isc.getManagedServices());
		
		return isc;
	}
}
