package leet_code.array_practice;

import java.util.HashMap;
import java.util.Map;


/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

 * */
public class CheckIfNandItsDoubleExist {
	public static boolean checkIfExist(int[] arr) {
		
		Map<Integer,Integer> cache = new HashMap<Integer, Integer>();
		
		for(Integer v : arr) {
			cache.put(v, cache.getOrDefault(v, 0)+1);
		}
		
		for(Integer v : arr) {
			int dble = 2*v;
			if(v == 0) {
				if(cache.containsKey(dble) && cache.get(dble)>1){
					return true;
				}
			}else {
				if(cache.containsKey(dble) && cache.get(dble)>0){
					return true;
				}
			}
			
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] arr = {-2,0,10,-19,4,6,-8};
		System.out.print(checkIfExist(arr));
	}
}
