package leet_code.array_practice;
/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.

Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:
 * 
 * Solution ( Yogesh ) : use two pointer i , cur 
 * step 2 : traverse i and cur until either i!=cur || ar[i]==val {first time when i and cur mimatch}
 * ( means when first val is found after that i and cur mismatch after then i and cur traverse at different positions )
 * step 3 : when value at i is not val it means it needs to be in array ( therfore copy value at i into value at cur 
 * step 4 : otherwise when a[i]==val it means it needs to be skip   
 * 
 * */

/**
 * Solution ( LeetCode ) : It has LOC
 * 
 * public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}
 * 
 * 
 * */
public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int i = 0 , cur = 0;
		int cnt = 0;
		int len = nums.length;
		for(Integer v : nums) {
			if(v.equals(val)) {
				cnt++;
			}
		}
		
		while( i < len ) {
			if( i!=cur || nums[i] == val ) {
				if( nums[i] != val ) {
					nums[cur] = nums[i];
					i++;cur++;
				}else {
					i++;
				}
			}else {
				i++;
				cur++;
			}
		}
		
//		for(Integer v : nums) {
//			System.out.print(v + ", ");
//		}
		return (len - cnt);
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		
		System.out.print(removeElement(nums, val));
	}
}
