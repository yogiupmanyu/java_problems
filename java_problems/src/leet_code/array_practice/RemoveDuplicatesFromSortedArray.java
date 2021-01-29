package leet_code.array_practice;
/**
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Solution ( Yogesh ) : 

 * */
public class RemoveDuplicatesFromSortedArray {
	
	public static int removeDuplicates(int[] nums) {
		int j = 1;
		int cur = 0;
		int len = nums.length;
		
		
		// check upto last 
		while( j < len ) {
			// when value is same as of the cur then increment the j  
			if( nums[j]==nums[cur] ){
				j++;
			}else {
				// when first change noticed update with the cur+1 value and increment the cur and j
				// we are updating cur+ because the single instance should be in the of cur value and the next change value is stored after that 
				nums[cur+1]=nums[j];
				j++;cur++;
			}
		}
		
		for(Integer v : nums) {
			System.out.print(v + ", ");
		}
		
		return cur+1;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		
		System.out.print(removeDuplicates(nums));
	}

}
