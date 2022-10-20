package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_functions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItFunctionsDto {
	private String id;
	private double data_center_itspend_run_perc;
	private double end_user_computing_itspend_run_perc;
	private double it_service_desk_itspend_run_perc;
	private double network_itspend_run_perc;
	private double application_enhance_itspend_run_perc;
	private double application_support_itspend_run_perc;
	private double it_management_itspend_run_perc;
	
	private long data_center_itspend_run_value;
	private long end_user_computing_itspend_run_value;
	private long it_service_desk_itspend_run_value;
	private long network_itspend_run_value;
	private long application_enhance_itspend_run_value;
	private long application_support_itspend_run_value;
	private long it_management_itspend_run_value;
	
	private double data_center_fte_spread_perc;
	private double end_user_computing_fte_spread_perc;
	double it_service_desk_fte_spread_perc;
	double network_fte_spread_perc;
	double application_enhance_fte_spread_perc;
	double application_support_fte_spread_perc;
	double it_management_fte_spread_perc;
	
	int data_center_fte_spread_value;
	int end_user_computing_fte_spread_value;
	int it_service_desk_fte_spread_value;
	int network_fte_spread_value;
	int application_enhance_fte_spread_value;
	int application_support_fte_spread_value;
	int it_management_fte_spread_value;
	
	long total_itspend_run_value;
	int total_fte_spread_value;
	public ItFunctionsDto(double data_center_itspend_run_perc, double end_user_computing_itspend_run_perc,
			double it_service_desk_itspend_run_perc, double network_itspend_run_perc,
			double application_enhance_itspend_run_perc, double application_support_itspend_run_perc,
			double it_management_itspend_run_perc, double data_center_fte_spread_perc,
			double end_user_computing_fte_spread_perc, double it_service_desk_fte_spread_perc,
			double network_fte_spread_perc, double application_enhance_fte_spread_perc,
			double application_support_fte_spread_perc, double it_management_fte_spread_perc) {
		super();
		this.data_center_itspend_run_perc = data_center_itspend_run_perc;
		this.end_user_computing_itspend_run_perc = end_user_computing_itspend_run_perc;
		this.it_service_desk_itspend_run_perc = it_service_desk_itspend_run_perc;
		this.network_itspend_run_perc = network_itspend_run_perc;
		this.application_enhance_itspend_run_perc = application_enhance_itspend_run_perc;
		this.application_support_itspend_run_perc = application_support_itspend_run_perc;
		this.it_management_itspend_run_perc = it_management_itspend_run_perc;
		this.data_center_fte_spread_perc = data_center_fte_spread_perc;
		this.end_user_computing_fte_spread_perc = end_user_computing_fte_spread_perc;
		this.it_service_desk_fte_spread_perc = it_service_desk_fte_spread_perc;
		this.network_fte_spread_perc = network_fte_spread_perc;
		this.application_enhance_fte_spread_perc = application_enhance_fte_spread_perc;
		this.application_support_fte_spread_perc = application_support_fte_spread_perc;
		this.it_management_fte_spread_perc = it_management_fte_spread_perc;
	}
	
	public ItFunctionsDto() {
		
	}
	
}
