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
    
   
   
// Table-1
   
   @PostMapping("/input")
   public ResponseEntity<?> inputTablesFinal(@RequestBody InputTablesDto inp) {
   	InputTablesDto input = inpService.input_tables_final(inp);
       return ResponseEntity.ok(input);
       
   }
   
   @GetMapping("/getlist/{id}")    
   public ResponseEntity<InputTablesDto> getById(@PathVariable String id) {   
    Optional<InputTablesDto> inp2 = inpService.getById(id); 
 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
 	}
   
// @PutMapping("/update/{id}")
// public ResponseEntity<?> itPersonalCostFinalUpdate(@RequestBody InputTablesDto inp,@PathVariable String id){
// 	InputTablesDto input = inpService.itPersonal_Calculation_final(inp,id);
//		return ResponseEntity.ok("updated");
//
// }
 

 
 
 
// Table-2
    
   @PostMapping("/itpersonel/{id}")
   public ResponseEntity<?> itPersonalFinal(@RequestBody ItPersonnelDto itp,@PathVariable String id) {
	   ItPersonnelDto input = inpService.it_personal_final(itp,id);
       return ResponseEntity.ok(input);
   }
   
   
   
// Table-3   
   
   @PostMapping("/itpersonelcost/{id}")
   public ResponseEntity<?> itPersonalCostFinal(@RequestBody ItPersonalCostDto itp,@PathVariable String id) {
	   ItPersonalCostDto input = inpService.it_personal_cost_final(itp,id);
       return ResponseEntity.ok(input);
   }
   
   
    
   
   
// Table-4
    
   @PostMapping("/cost/{id}")
   public ResponseEntity<CostofTransformationDto> costofTransformation(@RequestBody CostofTransformationDto inp,@PathVariable String id) {
       CostofTransformationDto cot= inpService.costTransformation_calc(inp,id);
//       System.out.println(cot.getClient_perc());
       return ResponseEntity.ok(cot);    
       
   }
    
    

    
// Table 5- Pathfinder benchmark

    @PostMapping("/itspendcat")
    public ResponseEntity<?> itSpendCategories(@RequestBody ItSpendCategoriesDto isc) {
    	ItSpendCategoriesDto spend = spendService.itspend_categories_calc(isc);
        return ResponseEntity.ok(spend);
        
    }
    
    
    
    @GetMapping("/itrun/{itpersonnelid1}/{inputtablesid2}/{costtransformationid3}")
    public ResponseEntity<?> itRunSpend_calc(@PathVariable String itpersonnelid1,@PathVariable String inputtablesid2,@PathVariable String costtransformationid3) {
        ItRunSpendDto input = inpService.itRunSpend_calc(itpersonnelid1, inputtablesid2, costtransformationid3);
        return ResponseEntity.ok(input);
        
    }
    
    
    
    
    
    
    
    
    
    
    
//---------------------------------------------------------------- 
    //table 1,2,3 
    
    
//  @PostMapping("/fullcal")
//  public ResponseEntity<?> itPersonalCostFinal(@RequestBody InputTablesDto inp) {
//  	InputTablesDto input = inpService.itPersonal_Calculation_final(inp);
//      return ResponseEntity.ok(input);
//      
//  }  
}