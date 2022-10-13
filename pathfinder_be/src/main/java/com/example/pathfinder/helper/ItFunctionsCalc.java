package com.example.pathfinder.helper;

import org.springframework.stereotype.Component;

import com.example.pathfinder.dto.InputTablesDto;
import com.example.pathfinder.dto.ItFunctionsDto;
import com.example.pathfinder.dto.ItPersonnelDto;

@Component
public class ItFunctionsCalc {

	//19-pathfinder_it_functions

	public ItFunctionsDto calculateValue(ItFunctionsDto funct,InputTablesDto inp,ItPersonnelDto itp) {
		ItFunctionsDto obj=funct;
		
		obj.setData_center_itspend_run_perc(obj.getData_center_itspend_run_perc());
		obj.setEnd_user_computing_itspend_run_perc(obj.getEnd_user_computing_itspend_run_perc());
		obj.setIt_service_desk_itspend_run_perc(obj.getIt_service_desk_itspend_run_perc());
		obj.setNetwork_itspend_run_perc(obj.getNetwork_itspend_run_perc());
		obj.setApplication_enhance_itspend_run_perc(obj.getApplication_enhance_itspend_run_perc());
		obj.setApplication_support_itspend_run_perc(obj.getApplication_support_itspend_run_perc());
		obj.setIt_management_itspend_run_perc(obj.getIt_management_itspend_run_perc());
		
		obj.setData_center_fte_spread_perc(obj.getData_center_fte_spread_perc());
		obj.setEnd_user_computing_fte_spread_perc(obj.getEnd_user_computing_fte_spread_perc());
		obj.setIt_service_desk_fte_spread_perc(obj.getIt_service_desk_fte_spread_perc());
		obj.setNetwork_fte_spread_perc(obj.getNetwork_fte_spread_perc());
		obj.setApplication_enhance_fte_spread_perc(obj.getApplication_enhance_fte_spread_perc());
		obj.setApplication_enhance_fte_spread_perc(obj.getApplication_enhance_fte_spread_perc());
		obj.setIt_management_fte_spread_perc(obj.getIt_management_fte_spread_perc());
		
		double datacenteritspendpercentage=obj.getData_center_itspend_run_perc()/100;
		double enduseritspendpercentage=obj.getEnd_user_computing_itspend_run_perc()/100;
		double itserviceitspendpercentage=obj.getIt_service_desk_itspend_run_perc()/100;
		double networkitspendpercentage=obj.getNetwork_itspend_run_perc()/100;
		double appenhanceitspendpercentage=obj.getApplication_enhance_itspend_run_perc()/100;
		double appsupportitspendpercentage=obj.getApplication_support_itspend_run_perc()/100;
		double itmanageitspendpercentage=obj.getIt_management_itspend_run_perc()/100;
		
		double datacenterftespreadpercentage=obj.getData_center_fte_spread_perc()/100;
		double enduserftespreadpercentage=obj.getEnd_user_computing_fte_spread_perc()/100;
		double itserviceftespreadpercentage=obj.getIt_service_desk_fte_spread_perc()/100;
		double networkftespreadpercentage=obj.getNetwork_fte_spread_perc()/100;
		double appenhanceftespreadpercentage=obj.getApplication_enhance_fte_spread_perc()/100;
		double appsupportftespreadpercentage=obj.getApplication_support_fte_spread_perc()/100;
		double itmanageftespreadpercentage=obj.getIt_management_fte_spread_perc()/100;
		
		obj.setData_center_itspend_run_value( (long) (datacenteritspendpercentage*inp.getRun_business_value()));
		obj.setEnd_user_computing_itspend_run_value((long) (enduseritspendpercentage*inp.getRun_business_value()));
		obj.setIt_service_desk_itspend_run_value((long) (itserviceitspendpercentage*inp.getRun_business_value()));
		obj.setNetwork_itspend_run_value((long) (networkitspendpercentage*inp.getRun_business_value()));
		obj.setApplication_enhance_itspend_run_value((long) (appenhanceitspendpercentage*inp.getRun_business_value()));
		obj.setApplication_support_itspend_run_value((long) (appsupportitspendpercentage*inp.getRun_business_value()));
		obj.setIt_management_itspend_run_value((long) (itmanageitspendpercentage*inp.getRun_business_value()));
		
		obj.setData_center_fte_spread_value((int) Math.round((datacenterftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setEnd_user_computing_fte_spread_value((int) Math.round((enduserftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setIt_service_desk_fte_spread_value((int) Math.round((itserviceftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setNetwork_fte_spread_value((int)Math.round ((networkftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setApplication_enhance_fte_spread_value((int)Math.round ((appenhanceftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setApplication_support_fte_spread_value((int) Math.round((appsupportftespreadpercentage*itp.getRun_fte_outsource())));
		obj.setIt_management_fte_spread_value((int) Math.round((itmanageftespreadpercentage*itp.getRun_fte_outsource())));
		
		obj.setTotal_itspend_run_value(obj.getData_center_itspend_run_value()+obj.getEnd_user_computing_itspend_run_value()+obj.getIt_service_desk_itspend_run_value()+obj.getNetwork_itspend_run_value()+obj.getApplication_enhance_itspend_run_value()+obj.getApplication_support_itspend_run_value()+obj.getIt_management_itspend_run_value());
		obj.setTotal_fte_spread_value(obj.getData_center_fte_spread_value()+obj.getEnd_user_computing_fte_spread_value()+obj.getIt_service_desk_fte_spread_value()+obj.getNetwork_fte_spread_value()+obj.getApplication_enhance_fte_spread_value()+obj.getApplication_support_fte_spread_value()+obj.getIt_management_fte_spread_value());
		return obj;
	}
}
