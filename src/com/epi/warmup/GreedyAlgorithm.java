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
	
	public static int minNoOfCoins_greedy(int n, int[] coins){
		
		int counter = 0;
		
		while (n > 0){
			
			int x = getLargestCoin(n, coins);
			
			if (x == -1){ //no solution found
				return -1;
			}
			
			counter++;
			n = n - x;
		}
		
		
		return counter;
	}
	
	private static int getLargestCoin(int value, int[] coins){
		int x = -1;
		
		//get largest coin less than or equal to N
		for (int coin : coins){
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
	
	//M[i][j] can denote the minimum of coins required to make change for the amount j
	//with coins i to n.
	//                      j
	//          0 1 2 3 4 5 6 7 8 9 10 11 12
	//   0 (1)  0 1 2 3 4 5 6 7 8 9 10 11 12
	// i 1 (6)  0 1 2 3 4 5 1 2 3 4  5  6  2
	//   2(10)  0 1 2 3 4 5 1 2 3 4  1  2  2
	
	//For example M[0][12] gives us the minimum number of coins for j=12 using only coin {1}.
	// M[2][12] gives us the minimum number of coins for j=12 using coins {1, 6, 10}.
	
	//For each coin from i to n we can choose whether to include it or not. 
	//If we do not include a coin then the minimum is the minimum from the previous coin.
	//minimum(j) = M[i-1][j] 
	//eg not including coin i=3(10) for j=12
	//minimum(j) = M[3-1][12] = M[2][12] = 2
	
	//If we include a coin, then the minimum is the current coins last minimum at (j-coin value)
	//plus one to denote the current coin.
	//minimum(j) = M[i][j-i(value)] + 1
	//eg including coin i=3(10) for j=12
	//minimum(j) = M[3][12-10] + 1 = M[3][2] + 1 = 2 + 1 = 3
	
	//How do we choose whether to include a coin or not? If the coin value is greater than j
	//then obviously we are not going to include it. Otherwise we must calculate both and
	//use the minimum value.
	
	//Time complexity of this algorithm is O(MN) where M is the number of coins in the denomination
	//and n is the sum j. We create a double array of coin.length and n values, so the space
	//complexity is also O(MN).
	
	public static int minNoOfCoins_dynamic(int n, int[] coins){
	
		//assert n is greater than 0, there are coins specified, and first coin = 1
		assert(n>0);
		assert(coins.length>0);
		assert(coins[0]==1);
		
		//if n is smaller than the smallest coin then no solution can be found
		if(n < coins[0]){
			return -1;
		}
		
		int [][]M = new int[coins.length][n+1];
		
		//when n = 0 then the minimum will always be zero
		for (int i=0; i<coins.length; i++){
			M[i][0] = 0;
		}
		
		//fill in the minimum values for the coin == 1
		for (int j=0; j<=n; j++){
			M[0][j] = j;
		}
		
		//loop from 1 to n
		for (int j=1; j<=n; j++){
			//loop through all coins 
			for (int i=1; i<coins.length; i++){
				if (coins[i] > j){
					//the coin value is greater than the current sum, so don't include it 
					//instead we use the minimum of the previous coin
					M[i][j] = M[i-1][j];
				} else {
					//otherwise we use either the minimum of the previous coin or we use
					//add one two to the current coins previous value (j - coin value)
					M[i][j] = Math.min(M[i-1][j], 1 + M[i][j-coins[i]]);
				}
			}
		}
			
		for (int i=0; i<coins.length; i++){
			for (int j=0; j<=n; j++){
				System.out.print(M[i][j]);
			}
			System.out.println("");
		}
		
		
		return M[coins.length-1][n];
	}
	
	public static void main(String args[]){
		
		assert(minNoOfCoins_greedy(37, US_COINS) == 4);
		assert(minNoOfCoins_greedy(75, US_COINS) == 2);
		assert(minNoOfCoins_greedy(10, US_COINS) == 1);
		assert(minNoOfCoins_greedy(30, US_COINS) == 2);
		

		assert(minNoOfCoins_dynamic(1, US_COINS) == 1);
		assert(minNoOfCoins_dynamic(5, US_COINS) == 1);
		assert(minNoOfCoins_dynamic(37, US_COINS) == 4);
		assert(minNoOfCoins_dynamic(75, US_COINS) == 2);
		assert(minNoOfCoins_dynamic(30, US_COINS) == 2);
		
		//assert that the greedy algorithm gives an incorrect answer
		//and the dynamic programming algorithm gives a correct answer
		assert(minNoOfCoins_dynamic(12, new int[]{1, 6, 10}) == 2);
		assert(minNoOfCoins_greedy(12, new int[]{1, 6, 10}) == 3);
		
	}
	
}
