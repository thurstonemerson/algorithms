package com.epi.warmup;

public class DynamicProgramming {
//	Dynamic Programming: Write a program that takes a positive integer N, and returns the number
//	of binary strings of length N such that there are no consecutive 1s. For example, if N = 3, the result
//	is 5, corresponding to the strings 000, 001, 010, 100, 101.
	
	public static int noConsectiveOnes(int n){
	
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
	
	public static void main(String args[]){
		
		assert(noConsectiveOnes(1)==2);
		assert(noConsectiveOnes(3)==5);
		assert(noConsectiveOnes(4)==8);
		
	}
}
