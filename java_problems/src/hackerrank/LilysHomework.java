package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LilysHomework {


    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
    	Map<Integer,Integer> index = new HashMap<Integer, Integer>();
    	List<Integer> sortedArr = new ArrayList<Integer>();
    	int i = 0;
    	
    	for(Integer val : arr) {
    		index.put(val, i);
    		sortedArr.add(val);
    		i++;
    	}
    	Collections.sort(sortedArr);
    	int cnt = 0;
    	for(int j=0;j<arr.length;j++) {
    		Integer scv = sortedArr.get(j);
    		if(!scv.equals(arr[j])) {
    			cnt++;
    			int indx = index.get(scv);
    			// we have to update the map also
    			swap(arr, indx, j);
    			updateIndex(index, arr);
    		}
    	}
    	
    	return cnt;
    }
    
    private static void updateIndex(Map<Integer,Integer> map,int[] arr) {
    	int i = 0;
    	for(Integer val : arr) {
    		map.put(val, i);
    		i++;
    	}
    }
    
    private static void swap(int[] arr , int i,int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    
    public static void main(String[] args) {
    	
    	int[] arr = {3,4,2,5,1};
    	System.out.println(lilysHomework(arr));
    }

}
