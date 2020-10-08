package com.spring.assement.ApiGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.assement.DAO.StringObject;
import com.spring.assement.ExceptionHandler.ApiRequestException;
import com.spring.assement.Service.HardCodedRepo;
import com.spring.assement.Service.StringService;

@CrossOrigin
@RestController
public class StringController {
	
	@Autowired
	StringService service;
	
	@Autowired
	HardCodedRepo repo;
	


	@PostMapping("/string")
	public ResponseEntity<String> LongestPalindrom(@RequestBody StringObject  strObj) {
		
		try {
			
			if(!strObj.getMystring().isEmpty()) {
				
				return service.longestPal(strObj.getMystring());
			
			}else {
				
				return ResponseEntity.noContent().build();
			}
			
			
			
		}catch(Exception e){

			 throw new ApiRequestException("null string");
	
			
		}

	}
	
	@GetMapping("/getString")
	public ResponseEntity<Object> getLongestPalindromeString(){
		
		return repo.getSavedString();
		
	}
}
