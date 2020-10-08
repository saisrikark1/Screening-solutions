package MyAssesment2;

import java.util.Scanner;

public class BinRev {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    System.out.println("Enter any positve Integer: ");
	    
		String numStr = sc.nextLine();
		
		System.out.println("Entered num is: " + numStr); 
		
		try {
			
			Integer.parseInt(numStr);
			
			System.out.println("After Binary Reversal:"+BinaryReversal(numStr));
			
		}catch(Exception e){
			
			System.out.println(e);
		}
	}
		
	static String BinaryReversal(String string) {
		
		String Binary = appendZeros(string);

		Integer Decimal = Integer.parseInt(Binary,2);
	
		return Decimal.toString();
	}


	
	static String appendZeros(String str) {
		
		int num = Integer.parseInt(str);
		
		String bin = Integer.toBinaryString(num);
		
		int N = (int) Math.ceil(( double) bin.length()/8);
		
		StringBuilder s = new StringBuilder();
		
		while(s.length() < N*8-bin.length()) {
			
			s.append("0");
		}
		
		s.append(bin);
		
		return s.reverse().toString();
		
	}

}
