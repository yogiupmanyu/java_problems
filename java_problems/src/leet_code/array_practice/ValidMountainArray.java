package leet_code.array_practice;


/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

    A.length >= 3
    There exists some i with 0 < i < A.length - 1 such that:
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]


Solution ( Leetcode ) :
class Solution {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
} 
 * */
public class ValidMountainArray {
	public static boolean validMountainArray(int[] A) {
    
		int i =0 , j = 1;
		boolean first = false;
		boolean res = true;
		// to handle edge case if array lenght is less than 3 and
		//if first value is greater than second then mountain cannot be created ( case when array is completely decreasing   
		if(A.length >= 3 && A[i] < A[j]) {
			while(j < A.length) {
				if(!first && (A[i] < A[j])) {
						i++;j++;
				}else if(!first && (A[i] > A[j])) { 
					first = true;
					i++;j++;
				}else if(first && (A[i] > A[j])) { // to handle when first decresing is noticed in array 
					i++;j++;
				}else {
					res = false;
					break;
				}
			}
		}else {
			return false;
		}
		// to handle if array is completely increasing then first is never true 
		return res && first;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,3,2,1};
		System.out.print(validMountainArray(arr));
	}
}
