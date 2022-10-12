package com.example.pathfinder_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.repo.ItSpendCategoriesRepo;

@Service

public class ItSpendCategoriesService {
	
	
@Autowired
ItSpendCategoriesRepo spendRepo;
//5-pathfinder_it_spend_categories

	public ItSpendCategoriesDto itspend_categories_calc(ItSpendCategoriesDto isc) {
		// TODO Auto-generated method stub
		ItSpendCategoriesDto obj6=spendRepo.save(isc);
		
		
		return obj6;
	}
	
	public Optional<ItSpendCategoriesDto> getByItSpendCatId(String itspendcatid) {
		// TODO Auto-generated method stub
		return spendRepo.findById(itspendcatid);
	}

	public List<ItSpendCategoriesDto> getAllItSpendCatId() {
		// TODO Auto-generated method stub
		return spendRepo.findAll();
	}

	
	
}
