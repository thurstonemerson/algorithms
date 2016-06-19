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
		
		//only loop through nodes that are not leaves (every node that is greater than n/2
		//will be a leaf)
		for (int x=(max_heap.length/2)-1; x >= 0; x--){
			heapify(x);
		}
	}
	
	public void heapify(int i){
		
		int left_index = (2*i)+1;
		int right_index = left_index+1;
		int max = i;
			
		//if the left index is larger than the root
		if (left_index < max_heap.length && max_heap[left_index] > max_heap[max]){
			max = left_index;
		}
		
		//if the right index is larger than the maximum
		if (right_index < max_heap.length && max_heap[right_index] > max_heap[max]){
			max = right_index;
		}
		
		System.out.println("max " + max + " and i " + i);
		if (max != i){
			//swap the max with the index
			int swap = max_heap[i];
			max_heap[i] = max_heap[max];
			max_heap[max] = swap;
			heapify(max);
		}
		
	}
	
	public void display(){
		for (int x=0; x < max_heap.length; x++){
			System.out.println(max_heap[x]);
		}
	}
	
	public static void main(String args[]){
		int a[] = new int[]{2, 5, 10, 15, 19, 20, 30, 50};
		
		Heap heap = new Heap(a);
		heap.display();
	}

}
