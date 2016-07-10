package com.epi.warmup;

public class DynamicProgramming {
//	Dynamic Programming: Write a program that takes a positive integer N, and returns the number
//	of binary strings of length N such that there are no consecutive 1s. For example, if N = 3, the result
//	is 5, corresponding to the strings 000, 001, 010, 100, 101.
	
	
	public static int noConsectiveOnes_Array(int n){
		
		int a[] = new int[n+1];
		int b[] = new int[n+1];
		a[1]=1;
		b[1]=1;
		
		for (int x=2; x<=n; x++){
			a[x] = a[x-1] + b[x-1];
			b[x] = a[x-1];
		}
		
		System.out.println("Number of strings ending in zero: " + a[n]);
		System.out.println("Number of strings ending in one: " + b[n]);
		return a[n] + b[n];
	}
	
	//calculates the number of binary strings (strings with 0 and 1) which do
	//not have consecutive 1s.
	//Idea 1: 
	//1) Generate all binary strings
	//2) Check if each string has consecutive 1s, counting those which do not
	//This approach is brute force and has a time complexity of O(n*2^n)
	//and a memory complexity of O(n). This will be unacceptable if n is over about 10.
	//Idea 2:
	//1) For n=1, the number of strings with no consecutive 1s and ending in 0 is 1
	//2) For n=1, the number of strings with no consecutive 1s and ending in 1 is 1
	//3) For each length of string starting from length 2, calculate the number of 
	//binary strings which may be generated without consecutive ones based on the 
	//previous calculation
	// (a contains count of binary strings with no consecutive 1s ending in 0)
	// (b contains count of binary strings with no consecutive 1s ending in 1)
	// Base case: a[1] = b[1] = 1
	// Other cases: a[i] = a[i-1] + b[i-1]
	//              b[i] = a[i-1]
	//This approach has a time complexity of O(n) and a memory complexity of
	//O(n) using arrays or O(1) using integer variables.
	public static int noConsectiveOnes(int n){

		int p0=1, p1=1, s0=0, s1=0;
		
		for (int x=2; x<=n; x++){
			s0=p0+p1;
			s1=p0;
			p0=s0;
			p1=s1;
		}
		
		System.out.println("Number of strings ending in zero: " + p0);
		System.out.println("Number of strings ending in one: " + p1);
		return p0 + p1;
	}
	
	public static void main(String args[]){
		
		assert(noConsectiveOnes(1)==2);
		assert(noConsectiveOnes(3)==5);
		assert(noConsectiveOnes(4)==8);
		
	}
}
