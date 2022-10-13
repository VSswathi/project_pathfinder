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
		
		ItSpendCategoriesDto obj6=spendRepo.save(isc);
		
		
		return obj6;
	}
	
	public Optional<ItSpendCategoriesDto> getByItSpendCatId(String itspendcatid) {
		
		return spendRepo.findById(itspendcatid);
	}

	public List<ItSpendCategoriesDto> getAllItSpendCatId() {
		
		return spendRepo.findAll();
	}

	public ItSpendCategoriesDto updateItSpendCat(ItSpendCategoriesDto isc, String itspendcatid) {
		ItSpendCategoriesDto old=spendRepo.findById(itspendcatid).get();
		old.setId(isc.getId());
		old.setYear(isc.getYear());
		old.setHardware(isc.getHardware());
		old.setSoftware(isc.getSoftware());
		old.setManagedServices(isc.getManagedServices());
		old.setHosted_cbs(isc.getHosted_cbs());
		return spendRepo.save(old);
	}

	
	
}
