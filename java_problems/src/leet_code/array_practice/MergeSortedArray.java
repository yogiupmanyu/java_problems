package leet_code.array_practice;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 * */

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums1.length==(m+n)) {
			int i = m-1;
			int j = n-1;
			int cur = nums1.length-1;
			
			while( i>=0 && j>= 0 ) {
				if(nums1[i]<nums2[j]) {
					nums1[cur]=nums2[j];
					j--;
					cur--;
				}else if(nums1[i]>=nums2[j]) {
					nums1[cur]=nums1[i];
					i--;
					cur--;
				}
			}
			
			while(j!=-1) {
				nums1[cur]=nums2[j];
				j--;
				cur--;
			}
			
			while(i!=-1) {
				nums1[cur]=nums1[i];
				i--;
				cur--;
			}
		}
		
		for(Integer v : nums1) {
			System.out.print(v+", ");
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		
		merge(nums1, m, nums2, n);
		
	}
}
