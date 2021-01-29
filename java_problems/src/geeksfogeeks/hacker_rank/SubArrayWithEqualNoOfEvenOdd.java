package java_problems.geeksfogeeks;

import java.util.HashMap;

public class SubArrayWithEqualNoOfEvenOdd {
    //private static int[] t = {12,4,7,8,9,2,11,0,2,13};
    private static int[] t = {1,2,1,2};

    public static boolean isEven(int p) {
        if(p%2==0) {
            return true;
        }else{
            return false;
        }

    }
// if no is odd then add -1 to  sum otherwise +1
    public static void main(String[] args) {
        int cur_sum = 0;
        int max = 0;
        int cur = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length;i++){
            if(isEven(t[i])){
                cur_sum--;
            }else{
                cur_sum++;
            }
            if(cur_sum==0){
                max = Math.max(cur_sum,i+1);
            }

            if(mp.containsKey(cur_sum)){
                max = Math.max(max,i-mp.get(cur_sum));
            }else{
                mp.put(cur_sum,i);
            }
        }

        System.out.println("Result :: "+max);
    }

}
