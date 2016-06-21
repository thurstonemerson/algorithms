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

//Searching: Write a nonrecursive program to perform binary search over a sorted array.
public class BinarySearch {
	
	
	public static int search(int []a, int key){
		
		int left = 0;
		int right = a.length - 1;
		int mid = 0;
		
		while (left <= right){
			
			//use of l + (r-l)/2 reorders equation to prevent overflow
			//which may occur when using (l + r)/2
			mid = left + (right-left)/2;
			
			if (a[mid] == key){
				System.out.println("Found " +a[mid] + " at index " + mid);
				return mid;
			}
			
			if (a[mid] > key){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(key +  " not found");
		return -1;
	}
	
	
	public static void main(String []args){
		
		int []a = new int[]{};
		
		assert(search(a, 2) == -1);
		
		a = new int[]{0, 1, 4, 5, 8, 10};
		
		assert(search(a, 4) == 2);
		
		assert(search(a, 10) == 5);
		
		assert(search(a, 15) == -1);
			
	}

}