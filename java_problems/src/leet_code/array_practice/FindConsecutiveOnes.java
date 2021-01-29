package leet_code.array_practice;
/**
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
    
Edge Cases : [0] , [1] , [0,1] 
    
 SOLUTION : 
 
 use two Variable cur and max update cur when 0 occurred and update max from max and cur into ( max ) , edge cases specifically handled
 
*/

public class FindConsecutiveOnes {
	
	 public int findMaxConsecutiveOnes(int[] nums) {

			int cur = 0;
			int max = 0;
			// to handle [0] , [1] edge cases
			if (nums.length == 1) {
				if (nums[0] == (1)) {
					max=1;
				}else{
	                max=0;
	            }
			} else {

				for (Integer val : nums) {
					if (val.equals(1)) {
						cur++;
					} else {
						max = Math.max(cur, max);
						cur = 0;
					}
				}
	            // to handle [0,1] edge case
	            max = Math.max(cur,max);

			}

			return max;
		}

}
