package leet_code.array_practice;

public class SquaresofaSortedArray {
	/**
	 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, 
	 * also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 
	 * */
	
	// Solution : solved (own)
	 public static int[] sortedSquares(int[] A) {
		int[] res = new int[A.length];
		
		int i = 0;
		int j = 0;
          boolean positive = false;
		// find first positive value
		for(int k = 0; k<A.length;k++) {
			if(A[k]>=0) {
				j = k;
                positive = true;
				break;
			}
		}
          
          //handle all negative
		if(!positive){
            j = A.length-1;
        }
		i = j-1;
		int l = 0;
		
		while( j<A.length && i>=0) {
			if( A[i]*A[i] > A[j]*A[j] ) {
				res[l] = A[j]*A[j];
				j++;
			}else {
				res[l] = A[i]*A[i];
				i--;
			}
			l++;
		}
		
		while(j<A.length) {
			res[l]=A[j]*A[j];
			l++;
			j++;
		}
		while(i>=0) {
			res[l]=A[i]*A[i];
			l++;
			i--;
		}
		
		return res;

    }
	
	// Solution : provided ( same as solved by us
	/**
	Intuition

	Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order, then some 
	non-negative elements with squares in increasing order.

	For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1], and the positive part
	 [4, 5, 6] with squares [16, 25, 36]. Our strategy is to iterate over the negative part in reverse, and the positive part in the 
	 forward direction.

	Algorithm

	We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction, and 
	another i in the negative direction.

	Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a 
	two-pointer technique.
	
	*/
	
	public static void main(String[] args) {
		int[] test = {-4,-1,0,3,10};
		
		for(Integer val : sortedSquares(test)) {
			System.out.println(val);
		}
	}
	
}
