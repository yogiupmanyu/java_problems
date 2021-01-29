package java_problems.geeksfogeeks;

import java.util.*;

public class Pairs{

    // Complete the pairs function below.
    // just assume the values are all diff in array and create a set then check if its present then increment the counter
    static int pairs(int k, int[] arr) {
        int cnt = 0;

        Set<Integer> numbers = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            numbers.add(arr[i]);
        }

        long matchCount = numbers.stream()
                .filter(i -> numbers.contains(i - k))
                .count();
        return (int)matchCount;
    }

    public static void main(String[] args){
        int[] a = {1,5,3,4,2};
        System.out.println(pairs(2,a));
    }
}
