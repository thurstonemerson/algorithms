package com.epi.warmup;


/**
 * The programming exercises in EPI are representative of what you will be asked
 * in an interview. We do not provide textbook-style review questions.
 * 
 * We present a small set of programming exercises suitable
 * for someone who needs to review basics. (You are unlikely to be asked these
 * questions - their purpose is to bootstrap reading EPI.)
 * 
 * When you write your solutions to these exercises, please code to the
 * following constraints:
 * 
 * - Do not use library calls. 
 * - Do not try to design clever solutions. (This means it is fine to use brute-force approaches.) 
 * - Assume valid inputs, and ignore internal errors like overflow, IO exceptions, etc. 
 * - Write unit tests for your programs. 
 * - Analyze your programs for time and space complexity.
 * 
 * @author Jessica
 * 
 */
public class FizzBuzz {
//	Primitive types: write a program that takes as input an integer, N, and prints
//	all the integers from 1 to N, replacing numbers divisible by 3 with “fizz”, numbers divisible by
//	5 with “buzz”, and numbers divisible by both with “fizz buzz”.
	
	 public static String getFizzBuzz(int N){
		 
		 StringBuilder buf= new StringBuilder();
		 
		 for (int x=1; x<=N; x++){
			 if (x%3 == 0 && x%5 == 0){
				 buf.append("fizz buzz");
			 } else if (x%3 == 0){
				 buf.append("fizz");
			 } else if (x%5 == 0){
				 buf.append("buzz");
			 } else {
				 buf.append(x);
			 }
			 
			 if (x < N){
				 buf.append(", ");
			 } 
		 }

		 System.out.println(buf.toString());
		 return buf.toString();
	 }
	
	 public static void main(String[] args) {	
		 	//n is 2 prints 1, 2
		 	assert("1, 2".equals(FizzBuzz.getFizzBuzz(2).trim()));
		 	
		 	//n is 3 prints 1, 2, fizz
		 	assert("1, 2, fizz".equals(FizzBuzz.getFizzBuzz(3).trim()));
		 	
		 	//n is 5 prints 1, 2, fizz, 4, buzz
		 	assert("1, 2, fizz, 4, buzz".equals(FizzBuzz.getFizzBuzz(5).trim()));
		 	
		 	//n is 15 prints 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz 
		 	assert("1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz".equals(FizzBuzz.getFizzBuzz(15).trim()));
		}
	
}


