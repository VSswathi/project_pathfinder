package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.RunOpexModelling2ADto;

@Repository
public interface RunOpexModelling2ARepo extends MongoRepository<RunOpexModelling2ADto, String>{

}
