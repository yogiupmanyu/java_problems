package geeksfogeeks.general;

import java.util.PriorityQueue;

/**
 * Find K’th Smallest/Largest Element in Unsorted Array
 * Solutions : 
 * 1. simple approach  sort the array return k-1 th element
 * 2. We can find k’th smallest element in time complexity better than O(N Log N). A simple optimization is to 
 *    create a Min Heap of the given n elements and call extractMin() k times.  
 * */
public class FindKthLargestFromArray {

	private static int kthSmallest(int[] arr, int n, int k) {
		if (k < arr.length) {
			// Build a heap of n elements: O(n) time
			PriorityQueue<Integer> cache = new PriorityQueue<Integer>(n + 5);

			for (Integer val : arr) {
				cache.add(val);
			}
			
			// Do extract min (k-1) times
			for (int i = 0; i < k - 1; i++)
				cache.poll();

			// Return root
			// return mh.getMin();
			return cache.poll();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 19 };
		int n = arr.length;
		int k = 4;
		System.out.println("K'th smallest element is " + kthSmallest(arr, n, k));
	}

}
