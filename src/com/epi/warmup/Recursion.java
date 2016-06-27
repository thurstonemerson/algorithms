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

	public static int power(int x, int n) {
		if (n == 0){
			System.out.println(x + "^" + n + "=1");
			return 1;
		}
		
		//recursively compute power of n/2
		int total = power(x, n / 2);

		//if even multiply the total together because x^n/2 * x^n/2 = x^n
		//eg x^6 = x^3 * x^3 
		if (n % 2 == 0) {
			System.out.println(x + "^" + n + "=" + (total * total));
			return total * total;
		}
		
		//if odd multiple the total together (plus once extra to offset what was 
		//lost in the division cast to an integer)
		//e.g. x^7 = x^3 * x^3 * x
		return total * total * x;
	}

	public static void main(String args[]) {
		
		assert(power(2, 8) == 256);
		assert(power(2, 7) == 128);
	}

}
