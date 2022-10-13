package com.example.pathfinder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder.dto.AssetClassificationSoftwareDto;

@Repository
public interface AssetClassificationSoftwareRepo extends MongoRepository<AssetClassificationSoftwareDto, String>{

}
