'''
The programming exercises in EPI are representative of what you will be asked
in an interview. We do not provide textbook-style review questions.
  
We present a small set of programming exercises suitable
for someone who needs to review basics. (You are unlikely to be asked these
questions - their purpose is to bootstrap reading EPI.)

When you write your solutions to these exercises, please code to the
following constraints:
 
- Do not use library calls. 
- Do not try to design clever solutions. (This means it is fine to use brute-force approaches.) 
- Assume valid inputs, and ignore internal errors like overflow, IO exceptions, etc. 
- Write unit tests for your programs. 
- Analyze your programs for time and space complexity.
 
@author: Jessica
'''

''' 
   Greedy Algorithms and Invariants: Write a program that takes an input a positive integer
   N, and returns the minimum number of coins in the US coinage system to create N cents. For example, if
   N = 37, the answer is 4, corresponding to a quarter, a dime, and two pennies.
   
   Possibilities:
   
   Greedy algorithm
   
   1) While N > 0
   2) Get the largest coin <= N (if it doesn't exist then there is no solution)
   3) Remove the largest coin value from N and increment a coin change counter
   
   Time Complexity is O(N) and space complexity is O(1)

   NOTE: this algorithm will only work in certain cases, for example the US coins. It will
   not work in a generic case for example coin set {1, 6, 10} the greedy algorithm will return
   a result of 3 (coins 10, 1, 1) for N=12, whereas the correct answer is 2 (coins 6, 6)
   
   Recursive algorithm
   
   1) Base case if N <= 0 then return 0 (No coins can be used to make change)
   2) Base case if N == a coin value in the set then return 1 (exactly one coin can be used)
   3) Otherwise return the minimum of 1 + recursivefunction(N - coin value) for each coin
   
   Time complexity is O(M^N) and space complexity is also O(M^N) from all the recursive calls
   on the call stack.
   
   Memoization
   
   Same as recursive algorithm but caching values already calculated between calls.
   
   Time complexity is O(MN) and space complexity is something like O(N^2 x M)
   
   Dynamic programming algorithm
   
   Generate a DP table M[i][j] where i is all coins in the coin set from 0 to i, and j is every 
   value from 0 to N 
   
   1) Base case for all coins 0 to i, set M[i][0] = 0 and M[0][j] = j
   (When j is 0 no coins can be used to make change, and when is j only coin 1 can be used)
   2) From 1 to j inclusive
       From 1 to i 
           if coin value i is > j
               M[i][j] = M[i-1][j] (set current value to the next smallest coins minimum value)
           else
               M[i][j] = Min(M[i-1][j], 1+M[i][j - coin value i])
               (set current value to the minimum of the next smallest coins minimum value or
               1 + minimum of the value j - coin value)
   3) return M[i][j]
   
   Time complexity is O(MN) and space complexity is also O(MN) due to the array size. Therefore
   this DP algorithm is the most efficient for the minimum coin change problem.
   
   '''
   
def min_coin_change_memoization(N, M, coin_set):   
    
   
   #1) Base case if N <= 0 then return 0 (No coins can be used to make change)
   if N <= 0:
       return 0
   
   if M[N] is not None:
       return M[N]
   
   #2) Base case if N == a coin value in the set then return 1 (exactly one coin can be used)
   for coin_val in coin_set:
       if N == coin_val:
           M[N] = 1
           return 1
       
   min = N
       
   #3) Otherwise return the minimum of 1 + recursivefunction(N - coin value) for each coin
   for coin_val in coin_set:
       val = 1 + min_coin_change_memoization(N - coin_val, M, coin_set)
       if val < min:
           min = val
           M[N] = min
           
   return M[N]
   
   

def min_coin_change_DP(N, coin_set):
    
    M = [[0 for i in range(N+1)] for j in range(len(coin_set))]
    
    #Base case, where i = 0 then minimum coins is the same as j
    for j in range(N+1):
       M[0][j] = j
       
    for j in range(1, N+1):
        for i in range(1, len(coin_set)):
            if coin_set[i] > j:
                M[i][j] = M[i-1][j] 
            else:
                M[i][j] = min(M[i-1][j], 1+M[i][j - coin_set[i]])
    
    print M
    return M.pop().pop()
   
if __name__ == "__main__":
       
    assert(min_coin_change_DP(12, [1, 6, 10]) == 2)
    assert(min_coin_change_memoization(12, [None]*13, [1, 6, 10]) == 2)

