package leet_code.array_practice;

import java.util.HashSet;

/**
 *
 *Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true 
 * Approach #2 (Sorting)
 * 
 * Approach #3 (Hash Table)

 * */

public class ContainsDuplicate {
	
	 public boolean containsDuplicate(int[] nums) {
		 HashSet<Integer> cnt = new HashSet<>();
		 
		 for(Integer val : nums) {
			 
			 if(cnt.contains(val))
				 return true;
			 
			 cnt.add(val);
			 
		 }
		 
		 return false;
	 }

}
