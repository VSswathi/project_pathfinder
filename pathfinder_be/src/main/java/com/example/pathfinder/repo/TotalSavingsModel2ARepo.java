package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.TotalSavingsModel2ADto;

@Repository
public interface TotalSavingsModel2ARepo extends MongoRepository<TotalSavingsModel2ADto, String>{

}
