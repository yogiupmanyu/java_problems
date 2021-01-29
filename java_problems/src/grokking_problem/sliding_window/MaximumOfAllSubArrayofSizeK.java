package grokking_problem.sliding_window;

public class MaximumOfAllSubArrayofSizeK {
	
	public static int getMaximumOfAllSubArray(int[] arr, int K) {
		
		int max = findMaxFirstTime(arr,K);
		
		int start = 0;
		int end = K-1;
		for(int i=K ;i<arr.length;i++) {
			if(max > arr[i]) {
				max = arr[i];
			}
				
			end++;
			start++;
		}
		
		return 0;
	}

	private static int findMaxFirstTime(int[] arr, int k) {
		int max = Integer.MIN_VALUE;
		for(int i=0 ; i<k ; i++){
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}

}
