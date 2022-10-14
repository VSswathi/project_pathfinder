package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.WaterfallTableDto;

@Repository
public interface WaterfallRepo extends MongoRepository<WaterfallTableDto, String>{

	
}