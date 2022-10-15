package com.example.pathfinder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder.dto.AssetClassificationDto;
import com.example.pathfinder.dto.AssetClassificationHardwareDto;
import com.example.pathfinder.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder.dto.SavingsOptimizationDto;
import com.example.pathfinder.service.AssetClassificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/asset")

public class AssetClassificationController {
	
	@Autowired
	AssetClassificationService assetService;
	


//7-pathfinder_asset_classification_hardware
	@PostMapping("/hardware/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
	 @Operation(summary = "hardware calculation")
	  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success",
	      content = {@Content(mediaType = "applcation/json",
	          schema = @Schema(implementation = AssetClassificationHardwareDto.class))})})
	public ResponseEntity<AssetClassificationHardwareDto> hardware_calc(@RequestBody AssetClassificationHardwareDto h,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
    	AssetClassificationHardwareDto val = assetService.hardware_calculation(h,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	@GetMapping("/hardware/{hardwareid}")    
	   public ResponseEntity<AssetClassificationHardwareDto> getByHardwareId(@PathVariable String hardwareid) {   
	    Optional<AssetClassificationHardwareDto> inp2 = assetService.getByHardwareId(hardwareid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	
	@GetMapping("/hardware")    
	   public ResponseEntity<List<AssetClassificationHardwareDto>> getAllHardware() {   
	    List<AssetClassificationHardwareDto> inp2 = assetService.getAllHardware(); 
	 		return new ResponseEntity<List<AssetClassificationHardwareDto>>(inp2, HttpStatus.OK);
	 }
	
	@PutMapping("/hardware/{hardwareid}/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public AssetClassificationHardwareDto updateHardware(@RequestBody AssetClassificationHardwareDto h, @PathVariable String hardwareid, @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3)
    {
        return assetService.updateHardware(h,hardwareid,itrunspendid1,inputtablesid2,itspendcategoriesid3);
    }
	
	
	
//8-pathfinder_asset_classification_software
	
	@PostMapping("/software/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
	public ResponseEntity<AssetClassificationSoftwareDto> software_calc(@RequestBody AssetClassificationSoftwareDto s,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
    	AssetClassificationSoftwareDto val = assetService.software_calculation(s,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	@GetMapping("/software/{softwareid}")    
	   public ResponseEntity<AssetClassificationSoftwareDto> getBySoftwareId(@PathVariable String softwareid) {   
	    Optional<AssetClassificationSoftwareDto> inp2 = assetService.getBySoftwareId(softwareid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	
	@GetMapping("/software")    
	   public ResponseEntity<List<AssetClassificationSoftwareDto>> getAllSoftware() {   
	    List<AssetClassificationSoftwareDto> inp2 = assetService.getAllSoftware(); 
	 		return new ResponseEntity<List<AssetClassificationSoftwareDto>>(inp2, HttpStatus.OK);
	 }
	
	@PutMapping("/software/{softwareid}/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public AssetClassificationSoftwareDto updateSoftware(@RequestBody AssetClassificationSoftwareDto s, @PathVariable String softwareid, @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3)
    {
        return assetService.updateSoftware(s,softwareid,itrunspendid1,inputtablesid2,itspendcategoriesid3);
    }
	
	
//9-pathfinder_asset_classification_managed
	
	@PostMapping("/managedservices/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public ResponseEntity<AssetClassificationManagedServicesDto> managed_calc(@RequestBody AssetClassificationManagedServicesDto m,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
        AssetClassificationManagedServicesDto val = assetService.managed_calculation(m,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	@GetMapping("/managedservices/{managedid}")    
	   public ResponseEntity<AssetClassificationManagedServicesDto> getByManagedId(@PathVariable String managedid) {   
	    Optional<AssetClassificationManagedServicesDto> inp2 = assetService.getByManagedId(managedid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	
	@GetMapping("/managedservices")    
	   public ResponseEntity<List<AssetClassificationManagedServicesDto>> getAllManaged() {   
	    List<AssetClassificationManagedServicesDto> inp2 = assetService.getAllManaged(); 
	 		return new ResponseEntity<List<AssetClassificationManagedServicesDto>>(inp2, HttpStatus.OK);
	 }
	
	@PutMapping("/managedservices/{managedid}/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public AssetClassificationManagedServicesDto updateManagedServices(@RequestBody AssetClassificationManagedServicesDto m, @PathVariable String managedid, @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3)
    {
        return assetService.updateManagedServices(m,managedid,itrunspendid1,inputtablesid2,itspendcategoriesid3);
    }
	
	
//	10-pathfinder_asset_classification_hosted
	
	@PostMapping("/hostedcbs/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public ResponseEntity<AssetClassificationHostedCbsDto> hosted_calc(@RequestBody AssetClassificationHostedCbsDto host,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
        AssetClassificationHostedCbsDto val = assetService.hosted_calculation(host,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	@GetMapping("/hostedcbs/{hostedid}")    
	   public ResponseEntity<AssetClassificationHostedCbsDto> getByHostedId(@PathVariable String hostedid) {   
	    Optional<AssetClassificationHostedCbsDto> inp2 = assetService.getByHostedId(hostedid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	
	@GetMapping("/hostedcbs")    
	   public ResponseEntity<List<AssetClassificationHostedCbsDto>> getAllHosted() {   
	    List<AssetClassificationHostedCbsDto> inp2 = assetService.getAllHosted(); 
	 		return new ResponseEntity<List<AssetClassificationHostedCbsDto>>(inp2, HttpStatus.OK);
	 }
	
	@PutMapping("/hostedcbs/{hostedid}/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public AssetClassificationHostedCbsDto updateHostedcbs(@RequestBody AssetClassificationHostedCbsDto host, @PathVariable String hostedid, @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3)
    {
        return assetService.updateHostedcbs(host,hostedid,itrunspendid1,inputtablesid2,itspendcategoriesid3);
    }
	
	
//11-pathfinder_asset_total
	
	@GetMapping("/itspendasset/{hardwareid1}/{softwareid2}/{managedid3}/{hostedid4}")
    public ResponseEntity<?> itSpend_calc(@PathVariable String hardwareid1,@PathVariable String softwareid2,@PathVariable String managedid3,@PathVariable String hostedid4) {
        AssetClassificationDto input = assetService.itSpendAsset_calc(hardwareid1, softwareid2, managedid3,hostedid4);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/itspendasset")    
	   public ResponseEntity<List<AssetClassificationDto>> getAllItSpendAsset() {   
	    List<AssetClassificationDto> inp2 = assetService.getAllItSpendAsset(); 
	 		return new ResponseEntity<List<AssetClassificationDto>>(inp2, HttpStatus.OK);
	 }
	
	
	
//12-pathfinder_saving_optimization

	@GetMapping("/savinglevers/{hardwareid1}/{softwareid2}/{managedid3}/{hostedid4}/{itpersonelid5}/{costtransid6}/{itrunspendid7}")
    public ResponseEntity<?> saving_calc(@PathVariable String hardwareid1,@PathVariable String softwareid2,@PathVariable String managedid3,@PathVariable String hostedid4,@PathVariable String itpersonelid5,@PathVariable String costtransid6,@PathVariable String itrunspendid7) {
		SavingsOptimizationDto input = assetService.saving_calculation(hardwareid1, softwareid2, managedid3,hostedid4,itpersonelid5,costtransid6,itrunspendid7);
        return ResponseEntity.ok(input);
        
    }
	
	@GetMapping("/savinglevers")    
	   public ResponseEntity<List<SavingsOptimizationDto>> getAllSavingsLevers() {   
	    List<SavingsOptimizationDto> inp2 = assetService.getAllSavingsLevers(); 
	 		return new ResponseEntity<List<SavingsOptimizationDto>>(inp2, HttpStatus.OK);
	 }
	
	
//13-pathfinder_itspend_run_personnel

	@GetMapping("/runpersonnel/{itpersonnelid1}/{inputtablesid2}/{costtransformationid3}")
	    public ResponseEntity<?> runPersonnel_calc(@PathVariable String itpersonnelid1,@PathVariable String inputtablesid2,@PathVariable String costtransformationid3) {
		 ItSpendOnRunPersonnelDto input = assetService.runPersonnel_calc(itpersonnelid1, inputtablesid2, costtransformationid3);
	        return ResponseEntity.ok(input);
	        
	    }
	 
	 @GetMapping("/runpersonnel")    
	   public ResponseEntity<List<ItSpendOnRunPersonnelDto>> getAllRunPersonnel() {   
	    List<ItSpendOnRunPersonnelDto> inp2 = assetService.getAllRunPersonnel(); 
	 		return new ResponseEntity<List<ItSpendOnRunPersonnelDto>>(inp2, HttpStatus.OK);
	 }
	
}
