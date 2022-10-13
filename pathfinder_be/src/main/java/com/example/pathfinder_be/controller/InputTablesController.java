package com.example.pathfinder_be.controller;



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

import com.example.pathfinder_be.dto.CostofTransformationDto;
import com.example.pathfinder_be.dto.InputTablesDto;
import com.example.pathfinder_be.dto.ItSpendCategoriesDto;
import com.example.pathfinder_be.helper.CalculationHelper;
import com.example.pathfinder_be.dto.ItPersonalCostDto;
import com.example.pathfinder_be.dto.ItPersonnelDto;
import com.example.pathfinder_be.dto.ItRunSpendDto;
import com.example.pathfinder_be.repo.CostofTransformationRepo;
import com.example.pathfinder_be.repo.InputTablesRepo;
import com.example.pathfinder_be.repo.ItpersonelRepo;
import com.example.pathfinder_be.service.InputTablesService;
import com.example.pathfinder_be.service.ItSpendCategoriesService;



@CrossOrigin("*")
@RestController
@RequestMapping("/inputtables")
public class InputTablesController {


	@Autowired
	InputTablesRepo inputRepo;

   @Autowired
   InputTablesService inpService;
   
   @Autowired
   ItpersonelRepo itpersonalRepo;
   
   @Autowired
   ItSpendCategoriesService spendService;
   
   @Autowired
   CalculationHelper helper;
   
   @Autowired
   CostofTransformationRepo cotRepo;
    
   
   
//1-pathfinder_input_tables
   
   @PostMapping("/input")
   public ResponseEntity<?> inputTablesFinal(@RequestBody InputTablesDto inp) {
   	InputTablesDto input = inpService.input_tables_final(inp);
       return ResponseEntity.ok(input);
       
   }
   
   @GetMapping("/getinputtables/{inputtablesid}")    
   public ResponseEntity<InputTablesDto> getByInputTablesId(@PathVariable String inputtablesid) {   
    Optional<InputTablesDto> inp2 = inpService.getByInputTablesId(inputtablesid); 
 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
 	}
   
   @PutMapping("/updateinputtables/{inputtablesid}")
   public InputTablesDto updateInputTables(@RequestBody InputTablesDto inp, @PathVariable String inputtablesid)
   {
       return inpService.updateInputTables( inp, inputtablesid);
   }
 
// 2-pathfinder_it_personnel
    
   @PostMapping("/itpersonel/{inputtablesid}")
   public ResponseEntity<?> itPersonalFinal(@RequestBody ItPersonnelDto itp,@PathVariable String inputtablesid) {
	   ItPersonnelDto input = inpService.it_personal_final(itp,inputtablesid);
       return ResponseEntity.ok(input);
   }
   
   @GetMapping("/getitpersonel/{itpersonelid}")    
   public ResponseEntity<ItPersonnelDto> getByitPersonalId(@PathVariable String itpersonelid) {   
    Optional<ItPersonnelDto> inp2 = inpService.getByitPersonalId(itpersonelid); 
 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
 	}
   @PutMapping("/updateitpersonel/{itpersonelid}")
   public ItPersonnelDto updateItPersonnel(@RequestBody ItPersonnelDto itp, @PathVariable String itpersonelid)
   {
       return inpService.updateItPersonnel( itp, itpersonelid);
   }

   
// 3-pathfinder_it_personnel_cost 
   
   @PostMapping("/itpersonelcost/{itpersonnelid}")
   public ResponseEntity<?> itPersonalCostFinal(@RequestBody ItPersonalCostDto itp,@PathVariable String itpersonnelid) {
	   ItPersonalCostDto input = inpService.it_personal_cost_final(itp,itpersonnelid);
       return ResponseEntity.ok(input);
   }
   
   @GetMapping("/getitpersonelcost/{itpersonelcostid}")    
   public ResponseEntity<ItPersonalCostDto> getByitPersonalCostId(@PathVariable String itpersonelcostid) {   
    Optional<ItPersonalCostDto> inp2 = inpService.getByitPersonalCostId(itpersonelcostid); 
 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
 	}
   
   @PutMapping("/updateitpersonelcost/{itpersonelcostid}/{itpersonnelid}")
   public ItPersonalCostDto updateItPersonnelCost(@RequestBody ItPersonalCostDto ipc, @PathVariable String itpersonelcostid,@PathVariable String itpersonnelid)
   {
       return inpService.updateItPersonnelCost( ipc, itpersonelcostid,itpersonnelid);
   }
    
// 4-pathfinder_cost_of_transformation
    
   @PostMapping("/cost/{inputtablesid}")
   public ResponseEntity<CostofTransformationDto> costofTransformation(@RequestBody CostofTransformationDto inp,@PathVariable String inputtablesid) {
       CostofTransformationDto cot= inpService.costTransformation_calc(inp,inputtablesid);
       return ResponseEntity.ok(cot);    
       
   }
   
   @GetMapping("/getcost/{costid}")    
   public ResponseEntity<CostofTransformationDto> getByCostId(@PathVariable String costid) {   
    Optional<CostofTransformationDto> inp2 = inpService.getByCostId(costid); 
 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
 	}
    
   @PutMapping("/updatecost/{costid}/{inputtablesid}")
   public CostofTransformationDto updateCost(@RequestBody CostofTransformationDto cot, @PathVariable String costid,@PathVariable String inputtablesid)
   {
       return inpService.updateCost( cot, costid,inputtablesid);
   }

    
// 5-pathfinder_it_spend_categories

    @PostMapping("/itspendcat")
    public ResponseEntity<?> itSpendCategories(@RequestBody ItSpendCategoriesDto isc) {
    	ItSpendCategoriesDto spend = spendService.itspend_categories_calc(isc);
        return ResponseEntity.ok(spend);
        
    }
    
    @GetMapping("/getitspendcat/{itspendcatid}")    
    public ResponseEntity<ItSpendCategoriesDto> getByItSpendCatId(@PathVariable String itspendcatid) {   
     Optional<ItSpendCategoriesDto> inp2 = spendService.getByItSpendCatId(itspendcatid); 
  		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
  	}
    
    @GetMapping("/getallitspendcat")    
    public ResponseEntity<List<ItSpendCategoriesDto>> getAllItSpendCatId() {   
     List<ItSpendCategoriesDto> inp2 = spendService.getAllItSpendCatId(); 
  		return new ResponseEntity<List<ItSpendCategoriesDto>>(inp2, HttpStatus.OK);
  	}
    
    @PutMapping("/updateitspendcat/{itspendcatid}")
    public ItSpendCategoriesDto updateItSpendCat(@RequestBody ItSpendCategoriesDto isc, @PathVariable String itspendcatid)
    {
        return spendService.updateItSpendCat( isc,itspendcatid);
    }

    
    //6-pathfinder_itrun_spend
    @GetMapping("/itrun/{itpersonnelid1}/{inputtablesid2}/{costtransformationid3}")
    public ResponseEntity<?> itRunSpend_calc(@PathVariable String itpersonnelid1,@PathVariable String inputtablesid2,@PathVariable String costtransformationid3) {
        ItRunSpendDto input = inpService.itRunSpend_calc(itpersonnelid1, inputtablesid2, costtransformationid3);
        return ResponseEntity.ok(input);
        
    }
}