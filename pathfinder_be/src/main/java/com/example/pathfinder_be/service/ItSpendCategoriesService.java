package com.example.pathfinder_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.repo.ItSpendCategoriesRepo;

@Service

public class ItSpendCategoriesService {
	
	
@Autowired
ItSpendCategoriesRepo spendRepo;

	public ItSpendCategoriesDto itspend_categories_calc(ItSpendCategoriesDto isc) {
		// TODO Auto-generated method stub
		ItSpendCategoriesDto obj6=spendRepo.save(isc);
		
		
		return obj6;
	}
	
}
