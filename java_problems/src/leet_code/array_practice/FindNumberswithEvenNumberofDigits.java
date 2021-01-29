package leet_code.array_practice;

public class FindNumberswithEvenNumberofDigits {

	/**
	 * Given an array nums of integers, return how many of them contain an even number of digits.

 

		Example 1:
		
		Input: nums = [12,345,2,6,7896]
		Output: 2
		Explanation: 
		12 contains 2 digits (even number of digits). 
		345 contains 3 digits (odd number of digits). 
		2 contains 1 digit (odd number of digits). 
		6 contains 1 digit (odd number of digits). 
		7896 contains 4 digits (even number of digits). 
		Therefore only 12 and 7896 contain an even number of digits.

	 * */
	public static int findNumberOfDigit(Integer i) {
		return i.toString().length();
	}
	
	 public static int findNumbers(int[] nums) {
		int cnt = 0;
		
		for(Integer val : nums) {
			int len = findNumberOfDigit(val);
			if( len % 2 == 0) {
				cnt++;
			}
		}
		
		return cnt;
	 }
	 
	 public static void main(String[] args) {
		 int[] arr = {12, 345, 2,6,7896};
		 
		 System.out.println(findNumbers(arr));
	 }
}
