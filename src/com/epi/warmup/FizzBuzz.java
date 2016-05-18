package com.epi.warmup;

import com.epi.AddingCredits.ClientsCreditsInfo;

/**
 * The programming exercises in EPI are representative of what you will be asked
 * in an interview. We do not provide textbook-style review questions.
 * 
 * In this document, we present a small set of programming exercises suitable
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
	
	 public static void printFizzBuzz(int N){
		 
		 for (int x=1; x<=N; x++){
			 if (x%3 == 0 && x%5 == 0){
				 System.out.print(" fizz buzz");
			 } else if (x%3 == 0){
				 System.out.print(" fizz");
			 } else if (x%5 == 0){
				 System.out.print(" buzz");
			 } else {
				 System.out.print(" " + x);
			 }
			 
			 if (x < N){
				 System.out.print(", ");
			 } else {
				 System.out.println();
			 }
		 }
	 }
	
	 public static void main(String[] args) {	
		 	//n is 2 prints 1, 2
		 	FizzBuzz.printFizzBuzz(2);
		 	
		 	//n is 3 prints 1, 2, fizz
		 	FizzBuzz.printFizzBuzz(3);
		 	
		 	//n is 5 prints 1, 2, fizz, 4, buzz
		 	FizzBuzz.printFizzBuzz(5);
		 	
		 	//n is 15 prints 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz 
		 	FizzBuzz.printFizzBuzz(15);
		}
	
}


