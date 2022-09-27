package com.example.pathfinder_be.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.CostofTransformationDto;
@Repository
public interface CostofTransformationRepo extends MongoRepository<CostofTransformationDto, String>{

	CostofTransformationDto save(CostofTransformationDto obj4);
	
}
