package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumLoss {

    private static int minimumLoss(long[] price){
        Map<Long,Integer> pos = new HashMap<>();
        int k = 0;
        for(Long val : price){
            pos.put(val,pos.getOrDefault(val,k));
            k++;
        }
        int len  = price.length;
        long[] p2 = new long[len];
        for(int i=0;i<len;i++){
            p2[i] = price[i];
        }
        Arrays.sort(p2);
        long minCost = Integer.MAX_VALUE;
        for(int i=1;i<len;i++){
            if(((p2[i]-p2[i-1]) < minCost) && ( pos.get(p2[i]) <  pos.get(p2[i-1]) ) ){
                minCost = p2[i]-p2[i-1];
            }
        }

        return (int)minCost;
    }
    public static void main(String[] args){
        long[] t = {5,10,3};
        System.out.println(minimumLoss(t));
    }
}
