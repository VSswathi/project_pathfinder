package com.example.pathfinder_be.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;

@Repository
public interface ItpersonelRepo extends MongoRepository<ItPersonnelDto, String> {

//	ItPersonnelDto save(ItPersonnelDto object);
//	double getIt_spend_on_personal_perc(String id);

//Query
	
	@Query("{ 'pathfinder_it_personnel': { $in: { 'it_spend_on_personal_perc': ?1 } } }")List<ItPersonnelDto> findByInstock(double it_spend_on_personal_perc);
	

}
