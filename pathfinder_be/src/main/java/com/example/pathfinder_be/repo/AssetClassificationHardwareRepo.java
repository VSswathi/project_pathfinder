package com.example.pathfinder_be.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareYear;

@Repository
public interface AssetClassificationHardwareRepo extends MongoRepository<AssetClassificationHardwareDto, String>{

	AssetClassificationHardwareDto save(AssetClassificationHardwareDto obj3);

}
