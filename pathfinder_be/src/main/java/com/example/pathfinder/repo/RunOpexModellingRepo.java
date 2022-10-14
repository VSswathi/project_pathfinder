package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.RunOpexModellingDto;

@Repository
public interface RunOpexModellingRepo extends MongoRepository<RunOpexModellingDto, String>{
	

}
