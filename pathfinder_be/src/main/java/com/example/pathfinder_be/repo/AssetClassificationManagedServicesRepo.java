package com.example.pathfinder_be.repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.AssetClassificationManagedServicesDto;



@Repository
public interface AssetClassificationManagedServicesRepo extends MongoRepository<AssetClassificationManagedServicesDto, String> {



   AssetClassificationHardwareDto save(AssetClassificationHardwareDto obj3);



}