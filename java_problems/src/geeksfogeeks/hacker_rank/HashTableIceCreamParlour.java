package java_problems.geeksfogeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTableIceCreamParlour {
    static void whatFlavors(int[] cost, int money) {
        //Arrays.sort(cost);

        Map<Integer,Integer> icrCreamCnt = new HashMap<>();

        int len = cost.length;
        StringBuilder res = new StringBuilder();

        for(int i=0; i<len ;i++){
            int x = cost[i];
            int y = money - x;
            // X + Y = MONEY  and we store x (current value) in the map with its index if its other combination is not present ,
            // y is other combination means if the combination for x (current value is not present in the array already )
            Integer j = icrCreamCnt.get(y);
            if( j!= null){
                res.append((j+1)+" "+(i+1));
                break;
            }
            icrCreamCnt.put(x,i);



        }
        System.out.print(res);

    }

    public static void main(String[] args) {
        int[] cnt = {2,2,3,4};
        int money = 4;

        whatFlavors(cnt,money);
    }
}
