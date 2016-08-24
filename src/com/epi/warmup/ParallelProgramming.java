package com.epi.warmup;

//Parallel Computing: Write a program which uses two threads to print the numbers from
//1 to 100 in order. One thread can only print odd numbers, the other can only print even numbers.
public class ParallelProgramming {

	private static Object lock = new Object();
	private static int current = 1;
	private static int MAX = 10;

	public static void main(String args[]) {

		Thread printEven = new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (lock) {
						if (current > MAX) {
							return;
						}
						if (current % 2 == 0) {
							System.out.println(current);
							current++;
						}
					}
				}
			}
		});
		Thread printOdd = new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (lock) {
						if (current > MAX) {
							return;
						}
						if (current % 2 != 0) {
							System.out.println(current);
							current++;
						}
					}
				}

			}
		});

		printOdd.start();
		printEven.start();

	}
}
