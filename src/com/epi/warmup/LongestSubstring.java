package com.epi.warmup;

import java.util.ArrayList;
import java.util.List;

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
	// single
	// character in an input string.
	// Adjacent or non-adjacent?
	private static String findLongestSubstring(String input) {

		List<String> substrings = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			char firstChar = input.charAt(i);
			int j = i + 1;
			while (firstChar == input.charAt(j)) {
				j++;
			}
			substrings.add(j - i, input.substring(i, j));
		}

		return "";
	}
	
	private static String findLongestSubstring2(String input) {

		List<String> substrings = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			for (int j=i+1; j < input.length(); j++){
				String substring = input.substring(i, j);
			}
		}

		return "";
	}
	

	public static void main(String[] args) {

		String sub = "abbccc";

	}

}
