package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.UserInputDto;

@Repository
public interface UserInputRepo extends MongoRepository<UserInputDto, String>{

}