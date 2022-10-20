package com.example.pathfinder.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.UserInputDto;

@Repository
public interface UserInputRepo extends MongoRepository<UserInputDto, String>{

	UserInputDto findByUserIdAndProjectName(String userId, String projectName);

	List<UserInputDto> findByUserId(String userid);


	UserInputDto findByProjectName(String projectname);


}