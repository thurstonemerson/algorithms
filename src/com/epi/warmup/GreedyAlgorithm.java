package com.epi.warmup;


public class GreedyAlgorithm {
//	Greedy Algorithms and Invariants: Write a program that takes an input a positive integer
//	N, and returns the minimum number of coins in the US coinage system to create N cents. For example, if
//	N = 37, the answer is 4, corresponding to a quarter, a dime, and two pennies.
// coins = {1, 5, 10, 25, 50, 100}

	//What to do if there is no solution?
	//What are the time complexities of the following loops?
	// Greedy solution:
	//ID 1: - While N > 0
	//      - x = largest coin that <= N
	//      - if no x return -1
	//      - counter++
	//      - N = N - x
	
	//       (or)
	//      - counter = counter + (n/x)
	//      - N = N mod x
	
	private static final int[] US_COINS = {1, 5, 10, 25, 50, 100};
	
	public static int minNoOfCoins_greedy(int n){
		
		int counter = 0;
		
		while (n > 0){
			
			int x = getLargestCoin(n);
			
			if (x == -1){ //no solution found
				return -1;
			}
			
			counter++;
			n = n - x;
		}
		
		
		return counter;
	}
	
	private static int getLargestCoin(int value){
		int x = -1;
		
		//get largest coin less than or equal to N
		for (int coin : US_COINS){
			if (coin <= value){
				x = coin;
			}
		}
		
		return x;
	}
	
	
	public static void main(String args[]){
		
		
		
	}
	
}
