package com.example.pathfinder_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathfinder_be.dto.AssetClassificationDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareDto;
import com.example.pathfinder_be.dto.AssetClassificationHardwareYear;
import com.example.pathfinder_be.dto.AssetClassificationHostedCbsDto;
import com.example.pathfinder_be.dto.AssetClassificationManagedServicesDto;
import com.example.pathfinder_be.dto.AssetClassificationSoftwareDto;
import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.dto.ItSpendOnRunPersonnelDto;
import com.example.pathfinder_be.dto.SavingsOptimizationDto;
import com.example.pathfinder_be.service.AssetClassificationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/asset")
public class AssetClassificationController {
	
	@Autowired
	AssetClassificationService assetService;
	


	
	@PostMapping("/hardware/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
	public ResponseEntity<AssetClassificationHardwareDto> hardware_calc(@RequestBody AssetClassificationHardwareDto h,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
    	AssetClassificationHardwareDto val = assetService.hardware_calculation(h,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	

	
	@PostMapping("/software/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
	public ResponseEntity<AssetClassificationSoftwareDto> software_calc(@RequestBody AssetClassificationSoftwareDto h,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
    	AssetClassificationSoftwareDto val = assetService.software_calculation(h,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	
//	
	@PostMapping("/managed/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public ResponseEntity<AssetClassificationManagedServicesDto> managed_calc(@RequestBody AssetClassificationManagedServicesDto m,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
        AssetClassificationManagedServicesDto val = assetService.managed_calculation(m,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
//	
	@PostMapping("/hosted/{itrunspendid1}/{inputtablesid2}/{itspendcategoriesid3}")
    public ResponseEntity<AssetClassificationHostedCbsDto> hosted_calc(@RequestBody AssetClassificationHostedCbsDto host,  @PathVariable String itrunspendid1, @PathVariable String inputtablesid2, @PathVariable String itspendcategoriesid3) {
        AssetClassificationHostedCbsDto val = assetService.hosted_calculation(host,itrunspendid1,inputtablesid2,itspendcategoriesid3);
        return ResponseEntity.ok(val);
        
    }
	
	@GetMapping("/itspendasset/{hardwareid1}/{softwareid2}/{managedid3}/{hostedid4}")
    public ResponseEntity<?> itSpend_calc(@PathVariable String hardwareid1,@PathVariable String softwareid2,@PathVariable String managedid3,@PathVariable String hostedid4) {
        AssetClassificationDto input = assetService.itSpendAsset_calc(hardwareid1, softwareid2, managedid3,hostedid4);
        return ResponseEntity.ok(input);
        
    }
	
	
	@GetMapping("/savinglevers/{hardwareid1}/{softwareid2}/{managedid3}/{hostedid4}/{itpersonelid5}/{costtransid6}/{itrunspendid7}")
    public ResponseEntity<?> saving_calc(@PathVariable String hardwareid1,@PathVariable String softwareid2,@PathVariable String managedid3,@PathVariable String hostedid4,@PathVariable String itpersonelid5,@PathVariable String costtransid6,@PathVariable String itrunspendid7) {
		SavingsOptimizationDto input = assetService.saving_calculation(hardwareid1, softwareid2, managedid3,hostedid4,itpersonelid5,costtransid6,itrunspendid7);
        return ResponseEntity.ok(input);
        
    }
	
	 @GetMapping("/runpersonnel/{itpersonnelid1}/{inputtablesid2}/{costtransformationid3}")
	    public ResponseEntity<?> runPersonnel_calc(@PathVariable String itpersonnelid1,@PathVariable String inputtablesid2,@PathVariable String costtransformationid3) {
		 ItSpendOnRunPersonnelDto input = assetService.runPersonnel_calc(itpersonnelid1, inputtablesid2, costtransformationid3);
	        return ResponseEntity.ok(input);
	        
	    }
	
}
