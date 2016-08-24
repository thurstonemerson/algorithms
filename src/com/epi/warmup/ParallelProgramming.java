package com.epi.warmup;

//Parallel Computing: Write a program which uses two threads to print the numbers from
//1 to 100 in order. One thread can only print odd numbers, the other can only print even numbers.
public class ParallelProgramming {
	
	private Object lock = new Object();

	public static void main(String args[]) {

		Thread printEven = new Thread(new Runnable(){
			public void run(){
				for (int x = 2; x <= 10; x+=2){
					System.out.println(x);
				}
		}});
		Thread printOdd = new Thread(new Runnable(){
			public void run(){
				for (int x = 1; x <= 9; x+=2){
					System.out.println(x);
				}
				
		}});
		
		printEven.start();
		printOdd.start();

	}
}
