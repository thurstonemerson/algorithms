package com.epi.warmup;

/**
 * The programming exercises in EPI are representative of what you will be asked
 * in an interview. We do not provide textbook-style review questions.
 * 
 * We present a small set of programming exercises suitable for someone who
 * needs to review basics. (You are unlikely to be asked these questions - their
 * purpose is to bootstrap reading EPI.)
 * 
 * When you write your solutions to these exercises, please code to the
 * following constraints:
 * 
 * - Do not use library calls. - Do not try to design clever solutions. (This
 * means it is fine to use brute-force approaches.) - Assume valid inputs, and
 * ignore internal errors like overflow, IO exceptions, etc. - Write unit tests
 * for your programs. - Analyze your programs for time and space complexity.
 * 
 * @author Jessica
 * 
 */

public class Recursion {
	// Write a recursive program that takes as input positive integers x and N,
	// and returns x to the power N.
	// You should use O(log N) multiplications.

	public int power(int x, int n) {
		if (n == 0)
			return 1;

		//if even, recursively compute power of n/2 until we are able to multiply
		//the total together
		if (n % 2 == 0) {
			int total = power(x, n / 2);
			return total * total;
		}
		
		//if odd, subtract one from n to make it even and recursively call power function
		return power(x, n-1) * x;
	}

	public void main(String args[]) {

	}

}
