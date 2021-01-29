package hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class LeftRotation {

    static String leftRotation(int[] arr , int d){
        Queue<Integer> cache = new LinkedList<>();
        for(Integer a : arr){
            cache.add(a);
        }
        int i = d;
        while(i > 0){
            int temp = cache.poll();
            cache.add(temp);
            i--;
        }

        StringBuilder res = new StringBuilder();
        cache.forEach(val ->{
            res.append(val+" ");
        });

        return res.toString();
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int d = 4;
        System.out.println(leftRotation(arr,d));
    }
}
