package com.epi.warmup;

import java.util.Enumeration;
import java.util.Hashtable;

import com.epi.warmup.HashTable.ArrayObject;

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

public class HashTable {
	// Hash tables: Write a program that finds the most common object in an
	// array of objects. The
	// objects consists of pairs of strings. Treat strings as being the same if
	// they are equal when converted to lower case.
	
	public static class ArrayObject{
		public String str1 = null;
		public String str2 = null;
		
		public ArrayObject(String str1, String str2){
			this.str1 = str1;
			this.str2 = str2;
		}
		
		@Override
		public int hashCode(){
			int hashcode = 1;
			
			if (this.str1 != null){
				hashcode += this.str1.hashCode();
			}
			if (this.str2 != null){
				hashcode += this.str2.hashCode();
			}
			
			return hashcode;
		}
		
		//return true if both the string objects are not null, and equal each other (ignoring case)
		@Override
		public boolean equals(Object obj){
			if (!(obj instanceof ArrayObject) || obj == null){
				return false;
			}
			
			ArrayObject compareObj = (ArrayObject) obj;
			
			boolean str1Equal = false, str2Equal = false;
			
			if (compareObj.str1 == null && this.str1 == null)
				str1Equal = true;
			
			if (compareObj.str2 == null && this.str2 == null)
				str2Equal = true;
				
			if (compareObj.str1 != null && this.str1 != null && compareObj.str1.equalsIgnoreCase(this.str1)){
				str1Equal = true;
			}
			
			if (compareObj.str2 != null && this.str2 != null && compareObj.str2.equalsIgnoreCase(this.str2)){
				str2Equal = true;
			}
			
			return str1Equal && str2Equal;
		}
	}
	
	public static void findMostCommonObjects(ArrayObject[] a){
		
		Hashtable<ArrayObject, Integer> objectCount = new Hashtable<ArrayObject, Integer>();
		
		//loop through the array and add one to the count for each object
		for (ArrayObject obj : a){
			Integer count = objectCount.get(obj);
			if (count != null){
				count++;
			} else {
				count = 1;
			}
			System.out.println(count);
			objectCount.put(obj, count);
		}
		
		int max = 0;
		
		//find the object with maximum count
		for (ArrayObject obj : objectCount.keySet()){
			Integer count = objectCount.get(obj);
			System.out.println("For object " + obj.str1 + " " + obj.str2 + " the count is " + count);
//			if (count ){
//				
//			}
		}
		
	}
	

	public static void main(String args[]) {
		
		ArrayObject obj1 = new HashTable.ArrayObject("hello", "ick");
		ArrayObject obj2 = new HashTable.ArrayObject("hello", "ick");
		ArrayObject obj3 = new HashTable.ArrayObject("", "ick");
		ArrayObject obj4 = new HashTable.ArrayObject("ff", "asdf");
		ArrayObject obj5 = new HashTable.ArrayObject("ff", "asdf");
		ArrayObject obj6 = new HashTable.ArrayObject(null, null);
		ArrayObject obj7 = new HashTable.ArrayObject("hello", "ick");

		ArrayObject[] a = new ArrayObject[]{obj1, obj2, obj3, obj4, obj5, obj6, obj7};
		findMostCommonObjects(a);
		
	}

}
