package leet_code.array_practice;

import java.util.Arrays;

public class HeightChecker {
	public static int heightChecker(int[] heights) {
		int[] sortedHeight = heights.clone();
		
		Arrays.parallelSort(sortedHeight);
		int cnt = 0;
		for(int i=0; i < heights.length ; i++) {
			if(heights[i]!=sortedHeight[i]) {
				cnt++;
			}
		}
		
		
		return cnt;
    }
	
	public static void main(String[] args) {
		int[] heights = {5,1,2,3,4};
		
		System.out.println(heightChecker(heights));
	}
}
