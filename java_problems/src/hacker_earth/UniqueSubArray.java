package java_problems.hacker_earth;

import java.util.*;

/**
 * A contiguous subarray is defined as unique if all the integers contained within it occur exactly once.
 * There is a unique weight associated with each of the subarray. Unique weight for any sub array equals it's length
 * if it's unique, 0 otherwise. Your task is to calculate the sum of unique weights of all the contiguous sub arrays
 * contained within a given array.
 * */
public class UniqueSubArray {

    private static void uniqueSubArrays(int[] arr ){
        int len = arr.length;
        Map<Integer,Integer> cache = new HashMap<>();
        int sum = len; // each single length sub array is unique
        for(int i = 0;i < len;i++){
            cache.put(arr[i],1);
            for(int j=i+1; j < len ;j++){
                if(cache.getOrDefault(arr[j],0) > 0){
                    break;
                }else{
                    sum += (j-i+1);
                    cache.put(arr[j],1);
                }
            }
            cache.clear();
        }

        System.out.print(sum);
    }

    private static void uniqueSubArrays_v2(int[] arr ){
        int len = arr.length;

        int sum = len; // each single length sub array is unique
        for(int i = 0;i < len;i++){
            for(int j=(len-1) ; j > 0 ;j--){
                if(isArrayUnique(arr,i,j)){
                    sum += ((j-i+1)*(j-i+2))/2 ; // ((n)(n-1))/2
                    break;
                }
            }
        }

        System.out.print(sum);
    }

    private static boolean isArrayUnique(int arr[] , int s, int e){
        Map<Integer,Integer> cache = new HashMap<>();
        for(int i = s; i < e ; i++ ){
            if(cache.getOrDefault(arr[i],0) > 0){
                return false;
            }else{
                cache.put(arr[i],1);
            }
        }
        return true;
    }


    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();                 // Reading input from STDIN

        while (t-- > 0) {
            int size = s.nextInt();
            int[] arr = new int[size];
            for(int i=0;i<arr.length;i++){
                arr[i] = s.nextInt();
            }
            uniqueSubArrays(arr);
        }
        //int[] arr = {1,2,3,4,5};
        //System.out.print(uniqueSubArrays(arr));
    }

}
