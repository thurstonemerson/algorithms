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

//Heaps: Write a program that builds a max-heap from an integer array. (You will need to implement
//a class suitable for representing heaps, but do not need to implement extract-max, insert key, etc.)
public class Heap {
	
	public int max_heap[] = null;
	
	public Heap(int a[]){
		max_heap = a;
	}
	
	public void heapify(int a[], int i){
		
		int left_index = 2*i;
		int right_index = (2*1)+1;
		int max = i;
		
		if (left_index < a.length && a[left_index] > a[i]){
			max = i;
		}
		if (right_index < a.length && a[right_index] > a[i]){
			max = i;
		}
		if (max != i){
			//swap the max with the index
			int swap = a[i];
			a[i] = a[max];
			a[max] = swap;
			heapify(a, max);
		}
		
	}
	
	public static void main(String args[]){
		int a[] = new int[]{};
	}

}
