package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.UserDetailsDto;
import com.example.pathfinder.dto.UserInputDto;

@Repository
public interface UserDetailsRepo extends MongoRepository<UserDetailsDto,String>{

	UserDetailsDto save(UserInputDto calculated);

}
