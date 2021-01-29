package leet_code.array_practice;
/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
	
	Solution : Bruteforce each time shift values O(n2) 
	2. use queue to rotate O(nO , O(n) space
	3. use reverse array technique :  1. reverse complete array , then reverse first k elements only , then reverse last n-k elements.

 * */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		k %= nums.length; 
		reverse(nums,0, nums.length-1);
		reverse(nums,0, k-1);
		reverse(nums,k , nums.length-1);
	}
	
	private void reverse(int[] nums,int start,int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
