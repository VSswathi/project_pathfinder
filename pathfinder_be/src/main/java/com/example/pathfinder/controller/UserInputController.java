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

import com.example.pathfinder.dto.UserDetailsDto;
import com.example.pathfinder.dto.UserInputDto;
import com.example.pathfinder.dto.UserValuesDto;
import com.example.pathfinder.response.ProjectNameOnly;
import com.example.pathfinder.service.UserInputService;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserInputController {

	@Autowired
	UserInputService userService;

// EXISTING USER json
	
	 @PostMapping("/input")
	   public ResponseEntity<?> userInput(@RequestBody UserInputDto inp) {
		 UserInputDto input = userService.userInput(inp);
	       return ResponseEntity.ok(input);    
	   }
	 
	 @GetMapping("/input/{inputid}")    
	   public ResponseEntity<UserInputDto> getByInputId(@PathVariable String inputid) {   
	    Optional<UserInputDto> inp2 = userService.getByInputId(inputid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	 
	 
	 @GetMapping("/input/projectname/{userid}")
		public ResponseEntity<ProjectNameOnly> list_allProjectName(@PathVariable String userid) {
		 ProjectNameOnly res=userService.getAllProjectNAme_only(userid);
		 return ResponseEntity.ok(res);
		}
	 
	 @GetMapping("/input")    
	   public ResponseEntity<List<UserInputDto>> getAllUserInputs() {   
	    List<UserInputDto> inp2 = userService.getAllUserInputs(); 
	 		return new ResponseEntity<List<UserInputDto>>(inp2, HttpStatus.OK);
	 	}
	 
	 @PutMapping("/input/{inputid}")
	   public UserInputDto updateUserInput(@RequestBody UserInputDto inp, @PathVariable String inputid)
	   {
	       return userService.updateUserInput( inp, inputid);
	   }

	 //Single Input Change	 
	 @PutMapping("/singleinput/{inputid}/{input}")
	   public UserInputDto updateUserInput( @PathVariable String inputid,@PathVariable long input)
	   {
	       return userService.updateUserInputonly_one( input, inputid);
	   }
	 
	 
	 
// NEW USER Values (only post methods)
	 
	 @GetMapping("/values/{userinputid1}")
	    public ResponseEntity<?> allInputValues(@PathVariable String userinputid1) {
		 
		  UserValuesDto input = userService.allInputValues(userinputid1);
	        return ResponseEntity.ok(input);
	        
	    }

//User Details(First page)
	 
	 @PostMapping("/details")
	   public ResponseEntity<UserInputDto> userDetails(@RequestBody UserDetailsDto inp) {
		 UserInputDto input = userService.userDetails(inp);
	       return ResponseEntity.ok(input);    
	   }
	 
	 @GetMapping("/details/{detalsid}")    
	   public ResponseEntity<UserDetailsDto> getByDetailsId(@PathVariable String detalsid) {   
	    Optional<UserDetailsDto> inp2 = userService.getByDetailsId(detalsid); 
	 		return new ResponseEntity<>(inp2.get(), HttpStatus.OK);
	 	}
	 
	 
	 
}