package java_problems.geeksfogeeks;

import java.io.IOException;
import java.util.*;

public class MissingNumber {

    static int[] missingNumbers(int[] arr, int[] brr) {
        Set<Integer> res = new HashSet<>();
        Map<Integer,Integer> cnt = new HashMap<>();
        for(Integer a : arr){
            cnt.put(a,cnt.getOrDefault(a,0)+1);
        }

        for(Integer b : brr){
            if(!cnt.containsKey(b) || cnt.get(b).equals(0)){
                res.add(b);
            }else{
                cnt.put(b,cnt.get(b)-1);
            }
        }
        int size_of_list = res.size();
        int[] res2 = new int[size_of_list];
        int i=0;
        for(Integer v : res ){
            res2[i]=v;
            i++;
        }
        return res2;
    }
    public static void main(String[] args) throws IOException {

    int[] v1 = {203 ,204, 205 ,206, 207, 208 ,203 ,204 ,205 ,206};
    int[] v2 = {203 ,204, 204, 205 ,206, 207, 205 ,208 ,203 ,206 ,205 ,206, 204};

    for(Integer t : missingNumbers(v1,v2)){
        System.out.print(t+" ");
    }

    }
}
