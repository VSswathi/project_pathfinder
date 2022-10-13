package com.example.pathfinder.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pathfinder_it_functions")
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
}
