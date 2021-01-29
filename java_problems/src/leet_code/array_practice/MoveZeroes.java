package leet_code.array_practice;
/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero 
 * elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

 * */
public class MoveZeroes {
	
	public static void moveZeroes(int[] nums) {
		int i = 0 , j=0;
		while( i < nums.length) {
			if(nums[i]==0) {
				i++;
			}else if(nums[i]!=0) {
				nums[j] = nums[i];
				i++;
				j++;
			}
		}
		if(j!=0) {
			while(j < nums.length) {
				nums[j] = 0;
				j++;
			}
		}
		for(Integer val : nums) {
			System.out.println(val);
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
	}

}
