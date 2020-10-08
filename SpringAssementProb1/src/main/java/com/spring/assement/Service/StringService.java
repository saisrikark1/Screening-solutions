package com.spring.assement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StringService {
	
	@Autowired
	HardCodedRepo repo;
	
	
	public ResponseEntity<String> longestPal(String str) {
				
				int maxlength = 1;
				int start = 0;
				int len =str.length();
				int low, hi;
				
				for(int i = 0; i < len; ++i) {
					low = i-1;
					hi = i;
					
					while(low >= 0 && hi < len
							&& str.charAt(low)==str.charAt(hi)) {
						if (hi - low +1 > maxlength) {
							start = low;
							maxlength = hi-low+1;
						}
						--low;
						++hi;
					}
					
					low = i-1;
					hi = i+1;
					
					while(low >= 0 && hi < len
							&& str.charAt(low)==str.charAt(hi)) {
						if (hi - low +1 > maxlength) {
							start = low;
							maxlength = hi-low+1;
						}
						--low;
						++hi;
					}
		
				}		
				
				String savingString = str.substring(start,start+maxlength);
				if(repo.saveString(savingString)) {
					
					return ResponseEntity.ok("Substring "+"'"+savingString+"'"+" is succesfully Saved!");
					
				}else {
					return ResponseEntity.ok("Substring "+"'"+savingString+"'"+"  length is than already existing String");
				}
				
			}
}
