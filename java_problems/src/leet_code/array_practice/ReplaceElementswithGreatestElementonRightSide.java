package leet_code.array_practice;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Solution ( Yogesh ) : 1. findMaxRight on two condition otherwise we can use the calculated value
					  2. first time at start , then when the maxRight itself is reached then again refresh the maxRight 
					  3. otherwise replace the value with max right because if the value is not equal to the arr[i] then maxRight
					   is maximum right value for arr[i] also. 
 * */

public class ReplaceElementswithGreatestElementonRightSide {
	 public static int[] replaceElements(int[] arr) {

		 if(arr.length==1) {
			 arr[0] = -1;
		 }else if(arr.length==2) {
			 arr[0] = arr[1];
			 arr[1] = -1;
		 }else {
			 int maxRight = findMaxRight(arr, 0);
			 arr[0] = maxRight;
			 int i= 1;
			 while(i < (arr.length-2)) {
				 if(arr[i]==maxRight) {
					 maxRight = findMaxRight(arr, i);
				 }
				 arr[i] = maxRight;
				 i++;
			 }
			 // i at second last position
			 arr[i] = arr[i+1];
			 arr[arr.length-1] = -1;
			 
		 }
		 return arr;
		
	 }
	 
	 private static int findMaxRight(int[] arr , int pos) {
		 int max = Integer.MIN_VALUE;
		 
		 for(int i=pos+1;i<arr.length;i++) {
			 max = Math.max(max, arr[i]);
		 }
		 return max;
	 }
	 
	 
	 public static void main(String[] arg) {
		 int[] arr = {17,18,5,4,6,1};
		 
		 for(Integer val : replaceElements(arr)){
			 System.out.println(val);
		 }
	 }
}
