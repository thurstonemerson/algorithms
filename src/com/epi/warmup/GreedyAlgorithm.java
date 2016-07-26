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
	
	//The greedy algorithm will not work for all denominations of money. 
	//For example with coins {1, 6, 10} and a sum j of 12, the greedy algorithm
	//will return the answer 3 using coins {10, 1, 1} whereas the true minimum is 2 {6, 6}. 
	
	//We require a dynamic programming algorithm for the generic case of finding the minimum of coins
	//to make change for a sum j where the coin denomination is denom[1] > denom[2] > ··· > denom[n] = 1.
	
	//C[i][j] can denote the minimum of coins required to make change for the amount j
	//with coins i to n.
	//                      j
	//          0 1 2 3 4 5 6 7 8 9 10 11 12
	//   1(10)  0 1 2 3 4 5 1 2 3 4  1  2  2
	// i 2 (6)  0 1 2 3 4 5 1 2 3 4  5  6  2
	//   3 (1)  0 1 2 3 4 5 6 7 8 9 10 11 12
	
	//For example C[3][12] gives us the minimum number of coins for j=12 using only coin {1}.
	// C[1][12] gives us the minimum number of coins for j=12 using coins {1, 6, 10}
	
	public static void main(String args[]){
		
		assert(minNoOfCoins_greedy(37) == 4);
		assert(minNoOfCoins_greedy(75) == 2);
		assert(minNoOfCoins_greedy(10) == 1);
		assert(minNoOfCoins_greedy(30) == 2);
		
		
		
	}
	
}
