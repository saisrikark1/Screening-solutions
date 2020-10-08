package com.spring.assement.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HardCodedRepo {
	
	static private String longestPalinString = "";

	public static String getLongestPalinString() {
		return longestPalinString;
	}

	public static boolean setLongestPalinString(String longestPalinString) {
		HardCodedRepo.longestPalinString = longestPalinString;
		return true;
	}
	
	public Boolean saveString(String s) {
		
		if(getLongestPalinString().length() <= s.length() ) {
			
			return setLongestPalinString(s);
			
		}else {
			
			return false;
			
		}	
	}
	
	public ResponseEntity<Object> getSavedString() {
		
		if(!(getLongestPalinString() == "")){
			
			return ResponseEntity.ok(getLongestPalinString());
			
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
}
