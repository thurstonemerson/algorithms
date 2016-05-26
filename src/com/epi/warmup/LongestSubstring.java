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

public class LongestSubstring {

	// Strings: Write a program to find the longest substring that consists of a
	// single character in an input string.
	// The first two loops in this algorithm will run in o(n^2) time.
	// The inner loop is dependent on the outer loop. The inner loop is
	// an arithmetic progression from 1, 2, 3, .., n. To find how many times the
	// inner loop runs, you have to sum the arithmetic series with the formula
	// x=(n(a1 + an))/2
	// which is x=(n(1+n))/2
	// x= (n + n^2)/2
	// Drop the lower order terms and we have o(n^2)
	// The repeating char loop will have o(n) runtime, therefore total runtime is o(n^3)

	private static String findLongestSubstring(String input) {

		String longestString = "";

		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String substring = input.substring(i, j);
				// check if substring has repeating chars
				if (hasRepeatingChars(substring)
						&& substring.length() >= longestString.length()) {
					longestString = substring;
				}
			}
		}

		System.out.println(longestString);
		return longestString;
	}

	private static boolean hasRepeatingChars(String str) {
		char firstChar = str.charAt(0);

		// return false if a character in the rest of the string is not the same
		// as the first character
		for (int i = 1; i < str.length(); i++) {
			if (firstChar != str.charAt(i)) {
				return false;
			}
		}

		// return true if there is only one character, or if the rest of the
		// characters are the same
		return true;
	}

	public static void main(String[] args) {

		String sub = "abbccc";
		assert (findLongestSubstring(sub).equals("ccc"));

		sub = "a";
		assert (findLongestSubstring(sub).equals("a"));

		sub = "addcccddd";
		assert (findLongestSubstring(sub).equals("ddd"));

		sub = "ddddddd";
		assert (findLongestSubstring(sub).equals("ddddddd"));
	}

}
