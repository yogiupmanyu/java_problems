package java_problems.geeksfogeeks;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestSubarray(List<Integer> arr) {
        // Write your code here

        int l = arr.size();
        int i = 0, maxlen = 0 , curLen = 0;

        if(arr.size() > 100000 ){
            return 0;
        }
        if(arr.size()==1){
            return 1;
        }else if(arr.size()<=0){
            return 0;
        }

        while (i < l-1) {
            int val = arr.get(i);
                if((Math.abs(val - arr.get(i + 1)) == 1
                        || Math.abs(val - arr.get(i + 1)) == 0)){
                    i++;
                    curLen++;
                }else {
                    maxlen = Math.max(curLen, maxlen);
                    i++;
                    curLen=0;
                }

        }

        // Any valid sub-array cannot be of length 1
        maxlen = (maxlen == 1) ? 0 : maxlen;

        // Return the maximum possible length
        return maxlen;
    }

}

public class LongestSubArray {

    public  static  void main(String[] args){
        List<Integer> t = new ArrayList<>();
        t.add(5);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        System.out.print(Result.longestSubarray(t));
    }
}

