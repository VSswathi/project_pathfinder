package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.RunOpexModelingOutsourceDto;

@Repository
public interface RunOpexModelingOutsourceRepo extends MongoRepository<RunOpexModelingOutsourceDto, String>{

}
